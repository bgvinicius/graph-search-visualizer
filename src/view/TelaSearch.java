package view;

import controllers.GraphController;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;

// TODO review this. Improve variable names. Make it clear...
public class TelaSearch extends javax.swing.JPanel {
    private final GraphController graphController;
    private javax.swing.JButton currentSpeed;
    private javax.swing.JPanel sideBarContainer;
    private javax.swing.JButton minus;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JButton plus;
    private JPanel container;
    private GraphComponent graphComponent;

    public TelaSearch(GraphController graphController) {
        this.graphController = graphController;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        this.setPreferredSize(new Dimension(800, 800));
        this.container = new JPanel();
        this.container.setPreferredSize(new Dimension(800, 800));
        this.container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));

        sideBarContainer = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        plus = new javax.swing.JButton();
        currentSpeed = new javax.swing.JButton();
        minus = new javax.swing.JButton();

        sideBarContainer.setLayout(new BoxLayout(sideBarContainer, BoxLayout.PAGE_AXIS));
        sideBarContainer.setBackground(new java.awt.Color(255, 255, 255));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Player.png"))); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        sideBarContainer.add(play);

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Pause.png"))); // NOI18N
        pause.setToolTipText("");
        pause.setFocusable(false);
        pause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        sideBarContainer.add(pause);

        plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Plus.png"))); // NOI18N
        plus.setFocusable(false);
        plus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plus.setPreferredSize(new java.awt.Dimension(38, 38));
        plus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sideBarContainer.add(plus);

        currentSpeed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        currentSpeed.setText("1");
        currentSpeed.setEnabled(false);
        currentSpeed.setFocusable(false);
        currentSpeed.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sideBarContainer.add(currentSpeed);

        minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Minus.png"))); // NOI18N
        minus.setFocusable(false);
        minus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sideBarContainer.add(minus);


        this.add(container);

        graphComponent = new GraphComponent(graphController);

        graphComponent.setPreferredSize(new Dimension(600, 600));
        sideBarContainer.setPreferredSize(new Dimension(50, 50));
        sideBarContainer.setMaximumSize(new Dimension(50, 2000));

        container.add(graphComponent);
        container.add(sideBarContainer);
//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(sideBarContainer);
//        sideBarContainer.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
//                .addGap(0, 556, Short.MAX_VALUE)
//                .addComponent(buttonsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
//        );
//        jPanel3Layout.setVerticalGroup(
//            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(buttonsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
//        );

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(sideBarContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addComponent(sideBarContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(0, 0, Short.MAX_VALUE))
//        );

        //pack();
    }

    private void playActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Iniciando busca no grafo. Grafo dirigido: " + this.graphController.isDirected());
        graphComponent.drawSearch(graphController.getSearchSequence());
    }                                    

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }
}
