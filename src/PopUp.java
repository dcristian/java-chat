
import java.awt.Color;

/**
 *
 * @author Dumitru Cristian
 */
public class PopUp extends javax.swing.JFrame {

    Client client;
    String destinatar, nume;

    PopUp(String destinatar, String nume, Client client) {

        super(nume + " in conversatie cu " + destinatar);
        initComponents();
        setDefaultCloseOperation(PopUp.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.decode("#102E37"));
        this.destinatar = destinatar;
        this.nume = nume;
        this.client = client;
        textConversatie.setEditable(false);
        labelConversatie.setText("Conversatie cu " + destinatar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textClient = new javax.swing.JTextField();
        butonTrimite = new javax.swing.JButton();
        JScrollPane = new javax.swing.JScrollPane();
        textConversatie = new javax.swing.JTextArea();
        labelConversatie = new javax.swing.JLabel();
        labelMesaj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textClient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textClientActionPerformed(evt);
            }
        });

        butonTrimite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        butonTrimite.setText("Trimite");
        butonTrimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonTrimiteActionPerformed(evt);
            }
        });

        textConversatie.setColumns(20);
        textConversatie.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        textConversatie.setRows(5);
        JScrollPane.setViewportView(textConversatie);

        labelConversatie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelConversatie.setForeground(new java.awt.Color(255, 255, 255));
        labelConversatie.setText("Conversatie");

        labelMesaj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMesaj.setForeground(new java.awt.Color(255, 255, 255));
        labelMesaj.setText("Mesaj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(butonTrimite, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMesaj)
                            .addComponent(labelConversatie, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConversatie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(labelMesaj)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textClient, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonTrimite, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textClientActionPerformed

        String s = textClient.getText();
        afisareMesaj(this.nume + " : " + s);
        client.trimiteMesajServer("MSG " + nume + " " + destinatar + " " + s);
        textClient.setText("");
    }//GEN-LAST:event_textClientActionPerformed

    private void butonTrimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonTrimiteActionPerformed

        String s = textClient.getText();
        afisareMesaj(nume + " : " + s);
        client.trimiteMesajServer("MSG " + nume + " " + destinatar + " " + s);
        textClient.setText("");
    }//GEN-LAST:event_butonTrimiteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        client.inchidereFereastra(destinatar, this);
    }//GEN-LAST:event_formWindowClosing

    public void afisareMesaj(String mesaj) {

        textConversatie.append(mesaj + "\n");
        textConversatie.setCaretPosition(textConversatie.getText().length() - 1);
    }

    public void changeNume(String numeNou) {

        this.setTitle(numeNou + " in conversatie cu " + destinatar);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton butonTrimite;
    private javax.swing.JLabel labelConversatie;
    private javax.swing.JLabel labelMesaj;
    private javax.swing.JTextField textClient;
    private javax.swing.JTextArea textConversatie;
    // End of variables declaration//GEN-END:variables
}
