package view;

import controllers.GraphController;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;

public class TelaRandomGraph extends javax.swing.JPanel {
    private final GraphController graphController;
    private javax.swing.JPanel sideBarContainer;
//    private javax.swing.JToolBar buttonsContainer;
    private javax.swing.JButton random;
    private GraphComponent graphComponent;
    private JPanel container;

    public TelaRandomGraph(GraphController graphController) {
        this.graphController = graphController;
        graphComponent = new GraphComponent(graphController);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.container = new JPanel();
        this.container.setPreferredSize(new Dimension(800, 800));

        this.setPreferredSize(new Dimension(800, 800));
        this.add(container);
        sideBarContainer = new javax.swing.JPanel();
//        buttonsContainer = new javax.swing.JToolBar();
        random = new javax.swing.JButton();

//        sideBarContainer.setBackground(new java.awt.Color(255, 255, 255));

//        buttonsContainer.setOrientation(javax.swing.SwingConstants.VERTICAL);
//        buttonsContainer.setRollover(true);
        container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
        graphComponent.setPreferredSize(new Dimension(600, 600));
        container.add(graphComponent, 0);

//        this.setBackground(Color.RED);
        random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Random.png"))); // NOI18N
        random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleGenerateRandomGraph();
            }
        });
//        buttonsContainer.add(random);
//        buttonsContainer.setBackground(Color.RED);

        this.setBackground(Color.WHITE);
        sideBarContainer.setBackground(Color.GRAY);
        sideBarContainer.add(random);
        sideBarContainer.setMaximumSize(new Dimension(50, 2000));
        sideBarContainer.setPreferredSize(new Dimension(50, 800));
        container.add(sideBarContainer, 1);

    }

    void handleGenerateRandomGraph() {
        container.setVisible(false);
        container.setSize(0, 0);
        container.setPreferredSize(new Dimension(0, 0));

        final JPanel newContainer = new JPanel();
        newContainer.setPreferredSize(new Dimension(800, 800));
        this.add(newContainer);
//
        graphController.generateNewGraph();
        this.graphComponent = new GraphComponent(graphController);
        newContainer.add(graphComponent);

        this.container = newContainer;

        sideBarContainer = new javax.swing.JPanel();
        random = new javax.swing.JButton();

        newContainer.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
        this.graphComponent.setPreferredSize(new Dimension(600, 600));
        newContainer.add(this.graphComponent, 0);

        random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Random.png"))); // NOI18N
        random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleGenerateRandomGraph();
            }
        });

        this.setBackground(Color.WHITE);
        sideBarContainer.setBackground(Color.GRAY);
        sideBarContainer.add(random);
        sideBarContainer.setMaximumSize(new Dimension(50, 2000));
        sideBarContainer.setPreferredSize(new Dimension(50, 800));
        newContainer.add(sideBarContainer, 1);

//        container.removeAll();

//        graphController.generateNewGraph();
//        this.add(new GraphComponent(graphController), 0);
//        graphComponent.initialize();
//        graphComponent.paintComponent(graphComponent.getGraphics());
    }
}