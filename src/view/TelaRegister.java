package view;

import controllers.GraphController;
import models.Vertex;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;

// TODO: improve variables naming
public class TelaRegister extends javax.swing.JPanel {

    private final GraphController graphController;
    private javax.swing.JTextField Arestas;
    private javax.swing.JCheckBox GrafoDirigido;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField Vertices;
    private javax.swing.JLabel exemplo1;
    private javax.swing.JLabel exemplo2;
    private javax.swing.JPanel formContainer;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private JPanel container;
    private JLabel orientacao;
    private GraphComponent graphComponent;

    public TelaRegister(GraphController graphController) {
        this.graphController = graphController;
        initComponents();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(1200, 1200));
        container = new JPanel();
        formContainer = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        Vertices = new javax.swing.JTextField();
        Arestas = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        exemplo1 = new javax.swing.JLabel();
        exemplo2 = new javax.swing.JLabel();
        orientacao = new JLabel();
        GrafoDirigido = new javax.swing.JCheckBox();
        formContainer.setBackground(new java.awt.Color(255, 255, 255));

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
        exemplo1.setText("ex: 1 2 3 4");

        exemplo2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        exemplo2.setText("ex: (1 2) (1 3) (2 4)");

        orientacao.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        orientacao.setText("Pressione 'Cadastrar' para exibir o grafo registrado.");

        GrafoDirigido.setBackground(new java.awt.Color(255, 255, 255));
        GrafoDirigido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        GrafoDirigido.setText("Grafo Dirigido");

        formContainer.setPreferredSize(new Dimension(350, 300));
        formContainer.setMaximumSize(new Dimension(350, 300));
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.PAGE_AXIS));
        formContainer.add(GrafoDirigido);
        formContainer.add(texto1);
        formContainer.add(exemplo1);
        formContainer.add(Vertices);
        formContainer.add(texto2);
        formContainer.add(exemplo2);
        formContainer.add(Arestas);
        formContainer.add(orientacao);
        formContainer.add(RegisterButton);

        container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
        container.add(formContainer);
        container.setPreferredSize(new Dimension(1200, 1200));
        graphController.emptyGraph(false);
        graphComponent = new GraphComponent(graphController);
        container.add(graphComponent);
        this.add(container);
    }

    private void VerticesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ArestasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        final String[] vertices = Vertices.getText().split(" ");
        this.graphController.emptyGraph(GrafoDirigido.isSelected());
        for (String vertex : vertices) {
            final int vertexNumber = Integer.parseInt(vertex);
            this.graphController.addVertex(new Vertex<>(vertexNumber));
        }
        
        graphComponent.initialize();
        graphComponent.repaint();
//        graphComponent.paintComponent(graphComponent.getGraphics());
//        final GraphComponent graphComponent = new GraphComponent(graphController);
//        graphComponent.setVisible(true);
//        graphComponent.setSize(600, 600);
//        graphComponent.setPreferredSize(new Dimension(600, 600));
//        container.add(graphComponent);
//        Arestas.getText();
    }
}
