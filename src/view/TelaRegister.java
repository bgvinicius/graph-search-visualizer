package view;

import java.awt.Color;

// TODO: improve variables naming
public class TelaRegister extends javax.swing.JPanel {

    private javax.swing.JTextField Arestas;
    private javax.swing.JCheckBox GrafoDirigido;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField Vertices;
    private javax.swing.JLabel exemplo1;
    private javax.swing.JLabel exemplo2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;

    public TelaRegister() {
        initComponents();
        
    }

    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        Vertices = new javax.swing.JTextField();
        Arestas = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        exemplo1 = new javax.swing.JLabel();
        exemplo2 = new javax.swing.JLabel();
        GrafoDirigido = new javax.swing.JCheckBox();
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        texto1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        texto1.setText("Digite os vértices do grafo: ");

        texto2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        texto2.setText("Digite as arestas do grafo:");

        Vertices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerticesActionPerformed(evt);
            }
        });

        Arestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArestasActionPerformed(evt);
            }
        });

        RegisterButton.setText("Cadastrar");
        RegisterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        exemplo1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        exemplo1.setText("ex: 1, 2, 3, 4");

        exemplo2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        exemplo2.setText("ex: (1, 2), (1, 3), (2, 4)");

        GrafoDirigido.setBackground(new java.awt.Color(255, 255, 255));
        GrafoDirigido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        GrafoDirigido.setText("Grafo Dirigido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(exemplo1))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(texto2)
                                .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Vertices)
                                .addComponent(Arestas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(exemplo2))
                            .addComponent(GrafoDirigido)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(RegisterButton)))
                .addGap(184, 184, 184))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(GrafoDirigido)
                .addGap(18, 18, 18)
                .addComponent(texto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exemplo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vertices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(texto2)
                .addGap(3, 3, 3)
                .addComponent(exemplo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Arestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void VerticesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void ArestasActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }
}
