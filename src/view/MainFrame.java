package view;

import javax.swing.*;
import java.awt.*;

// TODO: clear me :(((
public class MainFrame extends JFrame {

    private javax.swing.JMenu logoButton;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton newGraphButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton searchButton;


    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents() {
        mainPane = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        logoButton = new javax.swing.JMenu();
        newGraphButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));

//        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(mainPane);

        // TODO: clear this
        // desktop.setLayout(desktopLayout);
//        desktopLayout.setHorizontalGroup(
//            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 464, Short.MAX_VALUE)
//        );
//        desktopLayout.setVerticalGroup(
//            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 322, Short.MAX_VALUE)
//        );

        menu.setBackground(new java.awt.Color(204, 204, 204));

        logoButton.setBackground(new java.awt.Color(255, 255, 255));
        logoButton.setBorder(null);
        logoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Simbol.jpeg"))); // NOI18N
        logoButton.setText("GraphMaker");
        logoButton.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        logoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("ok.");
                GraphMakerActionPerformed(evt);
            }
        });
        menu.add(logoButton);

        newGraphButton.setBackground(new java.awt.Color(204, 204, 204));
        newGraphButton.setText("Gerar novo grafo");
        newGraphButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newGraphButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgActionPerformed(evt);
            }
        });
        menu.add(newGraphButton);

        registerButton.setBackground(new java.awt.Color(204, 204, 204));
        registerButton.setText("Cadastrar novo grafo");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        menu.add(registerButton);

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Iniciar busca");
        searchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                searchStateChanged(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        menu.add(searchButton);

        setJMenuBar(menu);

        // TODO: remove this
        //getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(desktop)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(desktop)
//        );


        this.setSize(800, 800);
        mainPane.setSize(800, 800);
        getContentPane().add(mainPane);
        final GraphComponent graphComponent = new GraphComponent();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));
        graphComponent.setBackground(new Color(157, 57, 20));
        mainPane.add(graphComponent);
        final JPanel jPanel = new JPanel();
        graphComponent.setPreferredSize(new Dimension(600, 600));
        jPanel.setBackground(new Color(0, 0, 0));
        jPanel.setMaximumSize(new Dimension(50, 2000));
        jPanel.setPreferredSize(new Dimension(50, 800));
//        jPanel.setMinimumSize(new Dimension(200, 200));

        mainPane.add(jPanel);
        //pack();
    }// </editor-fold>

    private void searchStateChanged(javax.swing.event.ChangeEvent evt) {
        // TODO add your handling code here:
    }

    //ao clicar no menu, abre uma nova tela de cadastro
    private void registerActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRegister reg = new TelaRegister();
        reg.setVisible(true);
        mainPane.removeAll();
        mainPane.add(reg);
        pack();
    }

    //ao clicar no menu, abre uma nova tela de buscar
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {
        TelaSearch s = new TelaSearch();
        mainPane.removeAll();
        mainPane.add(s);
        pack();
    }

    //ao clicar no menu, abre uma nova tela de gerar novo grafo
    private void newgActionPerformed(java.awt.event.ActionEvent evt) {
        TelaNewGraph g = new TelaNewGraph();
        mainPane.removeAll();
        mainPane.add(g);
        pack();
    }

    private void GraphMakerActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
