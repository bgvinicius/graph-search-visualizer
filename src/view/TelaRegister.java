package view;

import controllers.GraphController;
import models.Vertex;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaRegister extends javax.swing.JPanel {
    private final GraphController graphController;
    private javax.swing.JTextField arestasInput;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField verticesInput;
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
        this.graphController.emptyGraph(false);

        initComponents();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(800, 800));
        container = new JPanel();
        formContainer = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        verticesInput = new javax.swing.JTextField();
        arestasInput = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        exemplo1 = new javax.swing.JLabel();
        exemplo2 = new javax.swing.JLabel();
        orientacao = new JLabel();
        formContainer.setBackground(new java.awt.Color(255, 255, 255));

        texto1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        texto1.setText("Digite os vértices do grafo: ");

        texto2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        texto2.setText("Digite as arestas do grafo:");

        registerButton.setText("Cadastrar");
        registerButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        exemplo1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        exemplo1.setText("ex: 1 2 3 4");

        exemplo2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        exemplo2.setText("ex: (1,2) (1,3) (2,4)");

        orientacao.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        orientacao.setText("Pressione 'Cadastrar' para exibir o grafo registrado.");

        final JPanel vertexInputsContainer = new JPanel();
        final JPanel edgeInputsContainer = new JPanel();

        vertexInputsContainer.setPreferredSize(new Dimension(1000, 100));
        vertexInputsContainer.setMaximumSize(new Dimension(1000, 100));

        vertexInputsContainer.add(texto1);
        vertexInputsContainer.add(exemplo1);
        vertexInputsContainer.add(verticesInput);
        vertexInputsContainer.setLayout(new BoxLayout(vertexInputsContainer, BoxLayout.PAGE_AXIS));

        edgeInputsContainer.setMaximumSize(new Dimension(1000, 100));
        edgeInputsContainer.setPreferredSize(new Dimension(1000, 100));
        edgeInputsContainer.add(texto2);
        edgeInputsContainer.add(exemplo2);
        edgeInputsContainer.add(arestasInput);
        edgeInputsContainer.setLayout(new BoxLayout(edgeInputsContainer, BoxLayout.PAGE_AXIS));

        final JPanel inputsContainer = new JPanel();
        inputsContainer.setLayout(new BoxLayout(inputsContainer, BoxLayout.LINE_AXIS));
        inputsContainer.add(vertexInputsContainer);
        inputsContainer.add(edgeInputsContainer);

        formContainer.setPreferredSize(new Dimension(400, 150));
        formContainer.setMaximumSize(new Dimension(2500, 150));
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.PAGE_AXIS));

        formContainer.add(inputsContainer);

        formContainer.add(orientacao);
        formContainer.add(registerButton);

        formContainer.setAlignmentY(Component.TOP_ALIGNMENT);
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(formContainer);
        container.setPreferredSize(new Dimension(800, 800));
        graphComponent = new GraphComponent(graphController);
        container.add(graphComponent);
        this.add(container);
    }

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        final String[] vertices = verticesInput.getText().split(" ");
        this.graphController.emptyGraph(false);

        try {
            for (String vertex : vertices) {
                final int vertexNumber = Integer.parseInt(vertex);
                this.graphController.addVertex(new Vertex<>(vertexNumber));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Os vertices do grafo devem ser números! Por favor, insira apenas numeros, de acordo com o exemplo.",
                    "Erro ao inserir vértices",
                    JOptionPane.ERROR_MESSAGE);
            this.graphController.emptyGraph(false);
            return;
        }

        final String arestas = arestasInput.getText();

        try {
            addArestas(arestas);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, insira as arestas de acordo com o exemplo fornecido, i.e, pares no formato (x,y) separados por espaço.",
                    "Erro adicionando as arestas",
                    JOptionPane.ERROR_MESSAGE);
            this.graphController.emptyGraph(false);
            return;
        }

        container.setVisible(false);
        container.setSize(0, 0);
        container.setPreferredSize(new Dimension(0, 0));
        initComponents();
    }
    
    void addArestas(String arestasInput){
        ArrayList<String> aresta = new ArrayList<>();

        int i;
        for(i=0; i<arestasInput.length();i++){
            char aux = arestasInput.charAt(i);
            String x = Character.toString(aux);
            if(! x.equals(",")){
                aresta.add(x);
            }
        }
        int num1;
        int num2;

        // edges that don't have a vertex added on the graph. Tell user that some edges haven't been added.
        boolean badEdges = false;
        for(i=0; i<aresta.size(); i++){
            if(aresta.get(i).equals(")")){
                num1 = Integer.parseInt(aresta.get(i-2));
                num2 = Integer.parseInt(aresta.get(i-1));
                final boolean result = this.graphController.addEdge(new Vertex<>(num1), new Vertex<>(num2));

                if (!result) {
                    badEdges = true;
                }
            }
        }

        if (badEdges) {
            JOptionPane.showMessageDialog(
                    null,
                    "Algumas arestas não foram adicionadas, pois um dos vértices da aresta não estava " +
                            "inserido no grafo. Por favor, adicione apenas arestas cujo vértices já foram adicionados no grafo.",
                    "Erro inserindo algumas arestas",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}

