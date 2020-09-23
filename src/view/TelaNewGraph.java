package view;

import java.awt.*;

// TODO: remove me, I'm unused :(
//
public class TelaNewGraph extends javax.swing.JPanel {
    private javax.swing.JPanel sideBarContainer;
    private javax.swing.JToolBar buttonsContainer;
    private javax.swing.JButton play;

    public TelaNewGraph() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.setPreferredSize(new Dimension(800, 800));
        sideBarContainer = new javax.swing.JPanel();
        buttonsContainer = new javax.swing.JToolBar();
        play = new javax.swing.JButton();

        sideBarContainer.setBackground(new java.awt.Color(255, 255, 255));

        buttonsContainer.setOrientation(javax.swing.SwingConstants.VERTICAL);
        buttonsContainer.setRollover(true);

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Random.png"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // something..
            }
        });
        buttonsContainer.add(play);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(sideBarContainer);
        sideBarContainer.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 556, Short.MAX_VALUE)
                                .addComponent(buttonsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sideBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(sideBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        //pack();
    }
}