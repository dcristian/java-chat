
import java.awt.Color;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Dumitru Cristian
 */
public class ServerGUI extends javax.swing.JFrame {

    private Server server;
    private int port;

    ServerGUI(int port) {

        super("Server");
        initComponents();
        this.getContentPane().setBackground(Color.decode("#6082b6"));
        textPort.setText("" + port);
        textServer.setEditable(false);
        Lista.setEnabled(false);
        server = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelServer = new javax.swing.JLabel();
        labelListaClienti = new javax.swing.JLabel();
        textPort = new javax.swing.JTextField();
        butonStart = new javax.swing.JButton();
        labelPort = new javax.swing.JLabel();
        ScrollServer = new javax.swing.JScrollPane();
        textServer = new javax.swing.JTextArea();
        ScrollLista = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelServer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelServer.setText("Activitate Server");

        labelListaClienti.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelListaClienti.setText("Lista de clienti conectati");

        textPort.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        butonStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        butonStart.setText("Start");
        butonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonStartActionPerformed(evt);
            }
        });

        labelPort.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPort.setText("Port : ");

        textServer.setColumns(20);
        textServer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textServer.setRows(5);
        ScrollServer.setViewportView(textServer);

        Lista.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lista.setToolTipText("");
        ScrollLista.setViewportView(Lista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(labelPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(butonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelServer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollServer, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ScrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelListaClienti))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelListaClienti)
                    .addComponent(labelServer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollServer, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ScrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonStartActionPerformed

        if (server != null) {
            server.stop();
            server = null;
            textPort.setEditable(true);
            butonStart.setText("Start");
        } else {

            int port;
            try {
                port = Integer.parseInt(textPort.getText().trim());
            } catch (NumberFormatException e) {

                textServer.append("Invalid port number\n");
                return;
            }

            server = new Server(port, this);
            new ServerRunning().start();
            butonStart.setText("Stop");
            textPort.setEditable(false);
        }
    }//GEN-LAST:event_butonStartActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
            }

            server = null;
        }

        dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    void afisareActivitate(String mesaj) {

        textServer.append(mesaj);
        textServer.setCaretPosition(textServer.getText().length() - 1);
    }

    void afisareList(final ArrayList<String> listaActuala) {

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

    class ServerRunning extends Thread {

        @Override
        public void run() {
            server.start();
            butonStart.setText("Start");
            textPort.setEditable(true);
            server = null;
        }
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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ServerGUI(44).setVisible(true);
            }

        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Lista;
    private javax.swing.JScrollPane ScrollLista;
    private javax.swing.JScrollPane ScrollServer;
    private javax.swing.JButton butonStart;
    private javax.swing.JLabel labelListaClienti;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelServer;
    private javax.swing.JTextField textPort;
    private javax.swing.JTextArea textServer;
    // End of variables declaration//GEN-END:variables
}
