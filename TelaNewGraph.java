package View;
import java.awt.Color;


public class TelaNewGraph extends javax.swing.JFrame {

    public TelaNewGraph() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        GraphMaker = new javax.swing.JMenu();
        newg = new javax.swing.JMenu();
        register = new javax.swing.JMenu();
        search = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
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
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>                        

    private void searchStateChanged(javax.swing.event.ChangeEvent evt) {                                    
        // TODO add your handling code here:
    }                                   
    
    //ao clicar no menu, abre uma nova tela de cadastro
    private void registerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        TelaRegister reg = new TelaRegister();
        reg.setVisible(true);
        desktop.add(reg);
    }                                        
    
    //ao clicar no menu, abre uma nova tela de buscar
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {                                       
        TelaSearch s = new TelaSearch();
        s.setVisible(true);
        desktop.add(s);
    }                                      

    //ao clicar no menu, abre uma nova tela de gerar novo grafo
    private void newgActionPerformed(java.awt.event.ActionEvent evt) {                                     
        TelaNewGraph g = new TelaNewGraph();
        g.setVisible(true);
        
    }                                    

    private void GraphMakerActionPerformed(java.awt.event.ActionEvent evt) {                                           

    }                                          

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNewGraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu GraphMaker;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu newg;
    private javax.swing.JMenu register;
    private javax.swing.JMenu search;
    // End of variables declaration                   
}