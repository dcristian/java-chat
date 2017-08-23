
import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Dumitru Cristian
 */
class Client {

    private final int port;
    private final String adresa;
    private final ClientGUI gui;
    private Socket clientSocket;
    private DataInputStream inputServer;
    private DataOutputStream outputServer;
    private boolean activitateServer;
    private String nume;
    private final ArrayList<PopUp> listaFerestreUtilizatori;
    private final ArrayList<String> lista_utilizatori_in_conversatie;

    Client(int port, String adresa, ClientGUI gui) {

        this.port = port;
        this.adresa = adresa;
        this.gui = gui;
        listaFerestreUtilizatori = new ArrayList();
        lista_utilizatori_in_conversatie = new ArrayList<>();
    }

    public boolean conectare() {

        try {
            clientSocket = new Socket(adresa, port);
        } catch (IOException e) {
            afisareMesajServer("Serverul cu datele introduse nu e disponibil\n\n");
            return false;
        }
        try {
            inputServer = new DataInputStream(clientSocket.getInputStream());
            outputServer = new DataOutputStream(clientSocket.getOutputStream());
            return true;
        } catch (IOException e) {

            afisareMesajServer("Eroare la crearea fluxurilor IO\n\n");
            return false;
        }

    }

    public void username() {

        new Username().start();
    }

    class Username extends Thread {

        @Override
        public void run() {
            String fromServer;
            while (true) {
                try {
                    afisareMesajServer("Scrie un nume de utilizator\n");
                    fromServer = inputServer.readUTF();
                    afisareMesajServer(fromServer + "\n");
                    if (!fromServer.equals("Acest nume este folosit\n")) {
                        new FromServer().start();
                        gui.start();
                        gui.setTitle();
                        activitateServer = true;
                        break;
                    }

                } catch (IOException ex) {

                    afisareMesajServer("Serverul este offline\n\n");
                    gui.deconectare();
                    break;
                }
            }

        }
    }

    public void deconectare() {
        try {
            if (activitateServer) {
                activitateServer = false;
                inputServer.close();
                outputServer.close();
                clientSocket.close();
                gui.afisareServer("Te-ai deconectat de la server\n\n");
                gui.deconectare();
            } else {
                inputServer.close();
                outputServer.close();
                clientSocket.close();
                gui.deconectare();
            }
            closePopUps();
        } catch (IOException ex) {
        }
    }

    public void trimiteMesajServer(String mesaj) {
        try {
            outputServer.writeUTF(mesaj);
        } catch (IOException ex) {
            deconectare();
        }
    }

    public void afisareMesajServer(String mesaj) {

        gui.afisareServer(mesaj);
    }

    public void afisareConferinta(String mesaj) {

        gui.afisareConferinta(mesaj);
    }

    public void afisareLista(int numarUtilizatori) {

        System.out.println("afisareLista: " + numarUtilizatori);
        String utilizator;
        ArrayList<String> listaUtilizatoriOnline = new ArrayList<>();
        for (int indexUtilizator = 0; indexUtilizator < numarUtilizatori; indexUtilizator++) {
            try {
                utilizator = inputServer.readUTF();
                listaUtilizatoriOnline.add(utilizator);
            } catch (IOException ex) {
            }
        }
        gui.afisareLista(listaUtilizatoriOnline);
    }

    public String getNume() {

        return this.nume;
    }

    public void setNume(String nume) {

        this.nume = nume;
    }

    public void closePopUps() {

        for (int indexFereastra = 0; indexFereastra < lista_utilizatori_in_conversatie.size(); indexFereastra++) {

            listaFerestreUtilizatori.get(indexFereastra).dispose();
        }
        lista_utilizatori_in_conversatie.clear();
        listaFerestreUtilizatori.clear();
    }

    synchronized public void inchidereFereastra(String numeDestinatar, PopUp fereastra) {

        lista_utilizatori_in_conversatie.remove(numeDestinatar);
        listaFerestreUtilizatori.remove(fereastra);
    }

    public void deschidereFereastra(String numeDestinatar) {

        if (lista_utilizatori_in_conversatie.indexOf(numeDestinatar) == -1) {
            lista_utilizatori_in_conversatie.add(numeDestinatar);
            listaFerestreUtilizatori.add(new PopUp(numeDestinatar, nume, this));
            listaFerestreUtilizatori.get(listaFerestreUtilizatori.size() - 1).setVisible(true);
        }

    }

    public void mesajPrivat(String numeDestinatar, String mesaj) {

        int index = lista_utilizatori_in_conversatie.indexOf(numeDestinatar);
        if (index == -1) {
            lista_utilizatori_in_conversatie.add(numeDestinatar);
            listaFerestreUtilizatori.add(new PopUp(numeDestinatar, nume, this));
            listaFerestreUtilizatori.get(listaFerestreUtilizatori.size() - 1).setVisible(true);
            listaFerestreUtilizatori.get(listaFerestreUtilizatori.size() - 1).afisareMesaj(numeDestinatar + " " + mesaj);
        } else {
            listaFerestreUtilizatori.get(index).afisareMesaj(numeDestinatar + " " + mesaj);
        }
    }

    public void schimbare_nume_conversatii(String numeNou) {

        for (PopUp fereastra : listaFerestreUtilizatori) {

            fereastra.changeNume(numeNou);
        }
    }

    class FromServer extends Thread {

        @Override
        public void run() {

            while (true) {
                String fromServer = "";
                String mesajDescompus[];
                try {

                    fromServer = inputServer.readUTF();
                    mesajDescompus = fromServer.split(" ", 2);
                    switch (mesajDescompus[0]) {
                        case "BCAST":
                            afisareConferinta(mesajDescompus[1]);
                            break;
                        case "SERVER":
                            afisareMesajServer(mesajDescompus[1]);
                            break;
                        case "NUME":
                            nume = mesajDescompus[1];
                            gui.modificareNume(nume);
                            schimbare_nume_conversatii(nume);
                            trimiteMesajServer("LIST");
                            break;
                        case "LISTA":
                            int nrUtilizatori = Integer.parseInt(mesajDescompus[1]);
                            afisareLista(nrUtilizatori);
                            break;
                        case "MSG":
                            mesajDescompus = fromServer.split(" ", 3);
                            mesajPrivat(mesajDescompus[1], mesajDescompus[2]);
                    }
                } catch (IOException ex) {
                    if (activitateServer) {
                        activitateServer = false;
                        gui.afisareServer("Serverul este offline\n\n");
                        deconectare();
                    }
                    break;
                }
            }
        }
    }
}
