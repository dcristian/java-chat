
import java.awt.Color;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dumitru Cristian
 */
public class ClientGUI extends javax.swing.JFrame {

    private Client client;
    private String adresa;
    private int port;

    ClientGUI(String adresa, int port) {
        super("Client");
        initComponents();
        this.getContentPane().setBackground(Color.decode("#6082b6"));
        this.port = port;
        this.adresa = adresa;
        textServer.setEditable(false);
        textConferinta.setEditable(false);
        statusInitial();
        client = null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textClient = new javax.swing.JTextField();
        butonTrimite = new javax.swing.JButton();
        labelLista = new javax.swing.JLabel();
        labelAdresa = new javax.swing.JLabel();
        textAdresa = new javax.swing.JTextField();
        labelPort = new javax.swing.JLabel();
        textPort = new javax.swing.JTextField();
        butonConectare = new javax.swing.JButton();
        labelServer = new javax.swing.JLabel();
        labelConferinta = new javax.swing.JLabel();
        labelNume = new javax.swing.JLabel();
        butonNume = new javax.swing.JButton();
        textNume = new javax.swing.JTextField();
        butonLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textServer = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textConferinta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textClient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClientActionPerformed(evt);
            }
        });

        butonTrimite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butonTrimite.setText("Trimite");
        butonTrimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonTrimiteActionPerformed(evt);
            }
        });

        labelLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelLista.setText("Lista de clienti conectati");

        labelAdresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAdresa.setText("Adresa : ");

        textAdresa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        labelPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPort.setText("Port :");

        textPort.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        butonConectare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        butonConectare.setText("Conectare");
        butonConectare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonConectareActionPerformed(evt);
            }
        });

        labelServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelServer.setText("Mesaje de la Server");

        labelConferinta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelConferinta.setText("Conferinta");

        labelNume.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNume.setText("Nume : ");

        butonNume.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        butonNume.setText("Nume");
        butonNume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonNumeActionPerformed(evt);
            }
        });

        textNume.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        butonLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        butonLista.setText("List");
        butonLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonListaActionPerformed(evt);
            }
        });

        textServer.setColumns(20);
        textServer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textServer.setRows(5);
        jScrollPane2.setViewportView(textServer);

        textConferinta.setColumns(20);
        textConferinta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textConferinta.setRows(5);
        jScrollPane1.setViewportView(textConferinta);

        Lista.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Lista);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mesaj Conferinta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(textAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butonConectare)
                        .addGap(27, 27, 27)
                        .addComponent(labelLista))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelServer)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelConferinta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNume, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(textNume, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(butonNume, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(butonLista, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butonTrimite, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(labelAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(butonConectare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelLista)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labelServer)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelConferinta)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNume, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNume, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(butonNume, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butonLista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonTrimite, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonConectareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonConectareActionPerformed

        if (client != null) {
            client.trimiteMesajServer("QUIT");
            client.deconectare();
        } else {
            adresa = textAdresa.getText();
            try {
                port = Integer.parseInt(textPort.getText());
            } catch (NumberFormatException e) {
                return;
            }
            client = new Client(port, adresa, this);
            if (!client.conectare()) {
                client = null;
                return;
            }
            textNume.setEditable(true);
            butonNume.setEnabled(true);
            butonNume.setText("Trimite");
            textAdresa.setEditable(false);
            textPort.setEditable(false);
            butonConectare.setText("Deconectare");
            butonConectare.setEnabled(false);
            client.username();
        }
    }//GEN-LAST:event_butonConectareActionPerformed

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            String valoareLista = (String) Lista.getSelectedValue();
            evt.consume();
            String numeUtilizator[] = valoareLista.split("[)] ", 2);
            client.deschidereFereastra(numeUtilizator[1]);
        }
    }//GEN-LAST:event_ListaMouseClicked

    private void textClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClientActionPerformed

        client.trimiteMesajServer("BCAST " + textClient.getText());
        textClient.setText("");
    }//GEN-LAST:event_textClientActionPerformed

    private void butonTrimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonTrimiteActionPerformed

        client.trimiteMesajServer("BCAST " + textClient.getText());
        textClient.setText("");
    }//GEN-LAST:event_butonTrimiteActionPerformed

    private void butonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonListaActionPerformed

        client.trimiteMesajServer("LIST");

    }//GEN-LAST:event_butonListaActionPerformed

    private void butonNumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonNumeActionPerformed

        String nume;
        switch (butonNume.getText()) {
            case "Trimite":
                nume = textNume.getText();
                client.trimiteMesajServer(nume);
                break;
            case "Nume":
                afisareServer("Incerc sa-mi schimb numele :\n");
                textClient.setEditable(false);
                Lista.setEnabled(false);
                butonLista.setEnabled(false);
                butonTrimite.setEnabled(false);
                butonNume.setText("Schimba");
                textNume.setEditable(true);
                Lista.setEnabled(false);
                break;
            case "Schimba":
                nume = textNume.getText();
                client.trimiteMesajServer("NUME " + nume);
                textNume.setText(client.getNume());
                textNume.setEditable(false);
                textClient.setEditable(true);
                butonLista.setEnabled(true);
                butonTrimite.setEnabled(true);
                butonNume.setText("Nume");
                Lista.setEnabled(true);
        }
    }//GEN-LAST:event_butonNumeActionPerformed

    public void modificareNume(String m) {

        textNume.setText(m);
        setTitle();
    }

    public void setTitle() {

        this.setTitle("Client " + client.getNume());
    }

    public void start() {

        butonNume.setText("Nume");
        butonConectare.setEnabled(true);
        butonLista.setEnabled(true);
        textClient.setEditable(true);
        butonTrimite.setEnabled(true);
        textNume.setEditable(false);
        Lista.setEnabled(true);
        client.setNume(textNume.getText());
        client.trimiteMesajServer("LIST");
    }

    public void afisareServer(String mesaj) {

        textServer.append(mesaj);
        textServer.setCaretPosition(textServer.getText().length() - 1);
    }

    public void afisareConferinta(String mesaj) {

        textConferinta.append(mesaj + "\n");
        textConferinta.setCaretPosition(textConferinta.getText().length() - 1);
    }

    public void afisareLista(final ArrayList<String> listaActuala) {

        ListModel model = new AbstractListModel() {

            ArrayList<String> lista = listaActuala;

            @Override
            public int getSize() {
                return lista.size();
            }

            @Override
            public Object getElementAt(int index) {
                return (index + 1) + ") " + lista.get(index);
            }
        };
        Lista.setModel(model);
    }

    public void statusInitial() {

        textAdresa.setText(adresa);
        textAdresa.setEditable(true);
        textPort.setText("" + port);
        textPort.setEditable(true);
        Lista.setEnabled(false);
        butonLista.setEnabled(false);
        textClient.setEditable(false);
        butonTrimite.setEnabled(false);
        butonNume.setEnabled(false);
        textNume.setEditable(false);
        butonConectare.setEnabled(true);
    }

    public void deconectare() {

        statusInitial();
        textConferinta.setText("");
        textNume.setText("");
        setTitle();
        ArrayList<String> s = new ArrayList<>();
        afisareLista(s);
        butonConectare.setText("Conectare");
        client = null;
        this.setTitle("Client");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ClientGUI("localhost", 44).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Lista;
    private javax.swing.JButton butonConectare;
    private javax.swing.JButton butonLista;
    private javax.swing.JButton butonNume;
    private javax.swing.JButton butonTrimite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAdresa;
    private javax.swing.JLabel labelConferinta;
    private javax.swing.JLabel labelLista;
    private javax.swing.JLabel labelNume;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelServer;
    private javax.swing.JTextField textAdresa;
    private javax.swing.JTextField textClient;
    private javax.swing.JTextArea textConferinta;
    private javax.swing.JTextField textNume;
    private javax.swing.JTextField textPort;
    private javax.swing.JTextArea textServer;
    // End of variables declaration//GEN-END:variables
}
