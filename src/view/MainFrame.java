package view;

import controllers.GraphController;
import models.Vertex;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private javax.swing.JButton logoButton;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton newGraphButton;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton dfsSearchButton;
    private javax.swing.JButton bfsSearchButton;

    private final GraphController graphController;

    public MainFrame() {
        this.graphController = new GraphController();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents() {
        mainPane = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        logoButton = new javax.swing.JButton();
        newGraphButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        dfsSearchButton = new javax.swing.JButton();
        bfsSearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBackground(new java.awt.Color(204, 204, 204));

        logoButton.setBackground(new java.awt.Color(255, 255, 255));
        logoButton.setBorder(null);
        logoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Simbol.jpeg"))); // NOI18N
        logoButton.setText("GraphMaker");
        logoButton.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        logoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleLogoButtonClick(evt);
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

        dfsSearchButton.setBackground(new java.awt.Color(204, 204, 204));
        dfsSearchButton.setText("Iniciar busca DFS");
        dfsSearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dfsSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDfsSearch(evt);
            }
        });

        bfsSearchButton.setBackground(new java.awt.Color(204, 204, 204));
        bfsSearchButton.setText("Iniciar busca BFS");
        bfsSearchButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bfsSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleBfsSearch(evt);
            }
        });

        menu.add(dfsSearchButton);
        menu.add(bfsSearchButton);

        setJMenuBar(menu);

        this.setSize(800, 800);
        mainPane.setSize(800, 800);
        getContentPane().add(mainPane);
        final GraphComponent graphComponent = new GraphComponent(graphController);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));
        mainPane.add(graphComponent);
        final JPanel jPanel = new JPanel();
        graphComponent.setPreferredSize(new Dimension(600, 600));
        jPanel.setMaximumSize(new Dimension(50, 2000));
        jPanel.setPreferredSize(new Dimension(50, 800));

        mainPane.add(jPanel);
    }

    //ao clicar no menu, abre uma nova tela de cadastro
    private void registerActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRegister reg = new TelaRegister(this.graphController);
        mainPane.removeAll();
        mainPane.add(reg);
        pack();
    }

    //ao clicar no menu, abre uma nova tela de busca DFS
    private void handleDfsSearch(java.awt.event.ActionEvent evt) {
        AbstractSearchView s = new DFSSearchView(this.graphController);
        mainPane.removeAll();
        mainPane.add(s);
        pack();
    }

    //ao clicar no menu, abre uma nova tela de de busca BFS
    private void handleBfsSearch(java.awt.event.ActionEvent evt) {
        final String source = JOptionPane.showInputDialog("Por favor, digite o número do vértice fonte da busca");

        Integer parsedInteger;
        try {
            parsedInteger = Integer.parseInt(source);

            if (!this.graphController.containsVertex(new Vertex<>(parsedInteger))) {
                throw new Exception("Graph doesn't contain given vertex.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O vertice deve ser um número.", "Fonte incorreta", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O vertice entrado deve pertencer ao grafo.", "Fonte invalida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AbstractSearchView s = new BFSSearchView(this.graphController, new Vertex<>(parsedInteger));
        mainPane.removeAll();
        mainPane.add(s);
        pack();
    }

    //ao clicar no menu, abre uma nova tela de gerar novo grafo
    private void newgActionPerformed(java.awt.event.ActionEvent evt) {
        TelaRandomGraph g = new TelaRandomGraph(this.graphController);
        mainPane.removeAll();
        mainPane.add(g);
        pack();
    }

    private void handleLogoButtonClick(java.awt.event.ActionEvent evt) {
        getContentPane().removeAll();
        this.setSize(800, 800);
        mainPane = new javax.swing.JPanel();
        mainPane.setSize(800, 800);
        getContentPane().add(mainPane);
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.LINE_AXIS));

        mainPane.add(new GraphComponent(graphController));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
