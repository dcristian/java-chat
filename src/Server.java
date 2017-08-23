
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Dumitru Cristian
 */
public class Server {

    private final ArrayList<DataOutputStream> listaSockete;
    private final ArrayList<String> listaNumeUtilizatori;
    private final ArrayList<Conexiune> listaConexiuni;
    private ServerSocket serverSocket;
    private Socket clietSocket;
    private final int port;
    private final ServerGUI gui;
    private boolean activitateServer;

    Server(int port, ServerGUI gui) {

        listaSockete = new ArrayList<>();
        listaNumeUtilizatori = new ArrayList<>();
        listaConexiuni = new ArrayList<>();
        this.port = port;
        this.gui = gui;
    }

    public void start() {

        activitateServer = true;
        try {
            serverSocket = new ServerSocket(port);
            afisareActivitate("Serverul a pornit si asteapta clienti prin portul " + port + "\n");
            while (activitateServer) {
                try {
                    clietSocket = serverSocket.accept();
                    if (activitateServer) {
                        listaConexiuni.add(new Conexiune(clietSocket, listaSockete, listaNumeUtilizatori));
                    }
                } catch (IOException e) {
                }
            }
            afisareActivitate("Serverul s-a oprit\n\n");
        } catch (IOException e) {
            afisareActivitate("Portul " + port + " este ocupat\n");
        }
    }

    public void afisareActivitate(String mesaj) {

        gui.afisareActivitate(mesaj);
    }

    public void afisareLista() {

        gui.afisareList(listaNumeUtilizatori);
    }

    synchronized void stop() {

        activitateServer = false;
        try {
            Socket socket = new Socket("localhost", port);
            serverSocket.close();
            if (listaConexiuni != null) {
                for (Conexiune conex : listaConexiuni) {
                    conex.inchidereConexiune();
                }
            }
            listaConexiuni.clear();
            afisareLista();

        } catch (IOException ex) {
        }
    }

    class Conexiune extends Thread {

        private String nume;
        private boolean activitateClient = true;
        private Socket clientSocket = null;
        private DataInputStream inputClient = null;
        private DataOutputStream outputClient = null;
        private ArrayList<String> numeUtilizatori;
        private ArrayList<DataOutputStream> Sockete;

        Conexiune(Socket client, ArrayList<DataOutputStream> listaSockete, ArrayList<String> listaNumeUtilizatori) throws IOException {

            clientSocket = client;
            Sockete = listaSockete;
            numeUtilizatori = listaNumeUtilizatori;
            inputClient = new DataInputStream(clientSocket.getInputStream());
            outputClient = new DataOutputStream(clientSocket.getOutputStream());

            while (activitateServer) {
                try {
                    nume = inputClient.readUTF();
                    if (activitateServer && username(nume)) {
                        outputClient.writeUTF("Numele este acceptat");
                        afisareActivitate("Client nou - Numele Clientului : " + nume + "\n");
                        start();
                        break;
                    } else if (activitateServer) {
                        outputClient.writeUTF("Acest nume este folosit\n");
                    } else {
                        inputClient.close();
                        outputClient.close();
                        clientSocket.close();
                        break;
                    }

                } catch (IOException e) {
                    inputClient.close();
                    outputClient.close();
                    clientSocket.close();
                    break;
                }
            }
        }

        @Override
        public void run() {

            try {

                String mesaj;
                String mesajDescompus[];

                while (activitateClient) {
                    mesaj = inputClient.readUTF();
                    mesajDescompus = mesaj.split(" ", 4);
                    switch (mesajDescompus[0]) {
                        case "LIST":
                            list();
                            break;
                        case "NUME":
                            if (mesajDescompus[1] != null) {
                                schimbareNume(mesajDescompus[1]);
                            } else {
                                outputClient.writeUTF("SERVER Nu ai dat un nume\n");
                            }
                            break;
                        case "BCAST":
                            if (mesajDescompus.length == 3) {
                                broadcast(mesajDescompus[1] + " " + mesajDescompus[2]);
                            } else if (!mesajDescompus[1].equals("")) {
                                broadcast(mesajDescompus[1]);
                            } else {
                                outputClient.writeUTF("SERVER Nu ai dat un mesaj\n");
                            }
                            break;
                        case "QUIT":
                            quit();
                            break;
                        case "MSG":
                            if (!msg(mesajDescompus[1], mesajDescompus[2], mesajDescompus[3])) {
                                outputClient.writeUTF("SERVER Nu ai dat un mesaj\n");
                            }
                            break;
                    }

                }

            } catch (IOException e) {
                if (activitateClient) {
                    quit();
                }
            }
        }

        synchronized boolean username(String nume) {

            if (!listaNumeUtilizatori.contains(nume)) {
                listaNumeUtilizatori.add(nume);

                try {
                    Sockete.add(new DataOutputStream(clientSocket.getOutputStream()));
                } catch (IOException ex) {
                    return false;
                }

                afisareLista();
                return true;
            } else {
                return false;
            }

        }

        synchronized void list() {

            try {

                outputClient.writeUTF("LISTA " + numeUtilizatori.size());
                for (String numeUtilizator : numeUtilizatori) {
                    outputClient.writeUTF(numeUtilizator);
                }

            } catch (IOException e) {
                quit();
            }

        }

        synchronized void schimbareNume(String numeNou) {

            int indexNume = listaNumeUtilizatori.indexOf(nume);
            try {

                if (!listaNumeUtilizatori.contains(numeNou)) {
                    listaNumeUtilizatori.remove(indexNume);
                    listaNumeUtilizatori.add(indexNume, numeNou);
                    afisareActivitate("Utilizatorul " + nume + " si-a schimbat numele in " + numeNou + "\n");
                    nume = numeNou;
                    afisareLista();
                    outputClient.writeUTF("SERVER Numele " + numeNou + " este acceptat\n");
                    outputClient.writeUTF("NUME " + numeNou);
                } else {
                    outputClient.writeUTF("SERVER Numele " + numeNou + " este folosit\n");
                }

            } catch (IOException e) {
                quit();
            }

        }

        synchronized void broadcast(String message) {

            for (DataOutputStream socket : Sockete) {
                try {
                    socket.writeUTF("BCAST " + nume + " : " + message + "\n");
                } catch (IOException e) {
                }
            }
        }

        synchronized void quit() {

            int indexNume = listaNumeUtilizatori.indexOf(nume);
            listaNumeUtilizatori.remove(indexNume);
            Sockete.remove(indexNume);
            listaConexiuni.remove(indexNume);
            afisareLista();
            activitateClient = false;

            try {
                outputClient.close();
                inputClient.close();
                clientSocket.close();
            } catch (IOException ex) {
            }

            afisareActivitate("Utilizatorul " + nume + " s-a deconectat\n");
        }

        public void inchidereConexiune() {

            int index = listaNumeUtilizatori.indexOf(nume);
            listaNumeUtilizatori.remove(index);
            Sockete.remove(index);
            activitateClient = false;

            try {
                outputClient.close();
                inputClient.close();
                clientSocket.close();
            } catch (IOException ex) {
            }
        }

        synchronized Boolean msg(String from, String to, String mesaj) {

            int indexTo = numeUtilizatori.indexOf(to);
            if (indexTo != -1 && mesaj != null) {
                try {
                    Sockete.get(indexTo).writeUTF("MSG " + from + " : " + mesaj);
                    return true;
                } catch (IOException e) {
                    try {
                        outputClient.writeUTF("MSG " + to + " s-a deconectat");
                    } catch (IOException ex) {
                    }
                    return true;

                }
            } else if (indexTo == -1) {
                try {
                    outputClient.writeUTF("MSG " + to + " nu e online");
                } catch (IOException ex) {
                }
                return true;
            } else {
                return false;
            }
        }

    }
}
