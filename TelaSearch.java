package View;

import java.awt.Color;

public class TelaSearch extends javax.swing.JInternalFrame {

    public TelaSearch() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        GraphMaker = new javax.swing.JMenu();
        newg = new javax.swing.JMenu();
        register = new javax.swing.JMenu();
        search = new javax.swing.JMenu();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Player.png"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        jToolBar1.add(play);

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Pause.png"))); // NOI18N
        pause.setToolTipText("");
        pause.setFocusable(false);
        pause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        jToolBar1.add(pause);

        plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Plus.png"))); // NOI18N
        plus.setFocusable(false);
        plus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plus.setPreferredSize(new java.awt.Dimension(38, 38));
        plus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(plus);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("1");
        jButton4.setEnabled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToolBar1.add(jButton4);

        minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Minus.png"))); // NOI18N
        minus.setFocusable(false);
        minus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(minus);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 556, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        Menu.setBackground(new java.awt.Color(204, 204, 204));

        GraphMaker.setBackground(new java.awt.Color(255, 255, 255));
        GraphMaker.setBorder(null);
        GraphMaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Simbol.jpeg"))); // NOI18N
        GraphMaker.setText("GraphMaker");
        GraphMaker.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        GraphMaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphMakerActionPerformed(evt);
            }
        });
        Menu.add(GraphMaker);

        newg.setBackground(new java.awt.Color(204, 204, 204));
        newg.setText("Gerar novo grafo");
        newg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgActionPerformed(evt);
            }
        });
        Menu.add(newg);

        register.setBackground(new java.awt.Color(204, 204, 204));
        register.setText("Cadastrar novo grafo");
        register.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        register.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        Menu.add(register);

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setText("Iniciar busca");
        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.setBackground(Color.gray);
        search.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                searchStateChanged(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        Menu.add(search);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void GraphMakerActionPerformed(java.awt.event.ActionEvent evt) {                                           

    }                                          

    private void newgActionPerformed(java.awt.event.ActionEvent evt) {                                     
        TelaNewGraph novo = new TelaNewGraph();
        novo.setVisible(true);
    }                                    

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new TelaRegister().setVisible(true);
    }                                        

    private void searchStateChanged(javax.swing.event.ChangeEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       
        TelaSearch s = new TelaSearch();
        s.setVisible(true);
    }                                      

    private void playActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     


    // Variables declaration - do not modify                     
    private javax.swing.JMenu GraphMaker;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton minus;
    private javax.swing.JMenu newg;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JButton plus;
    private javax.swing.JMenu register;
    private javax.swing.JMenu search;
    // End of variables declaration                   
}
