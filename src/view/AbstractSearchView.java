package view;

import controllers.GraphController;
import models.SearchStep;
import view.graph.GraphComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

// TODO review this. Improve variable names. Make it clear...
public abstract class AbstractSearchView extends javax.swing.JPanel {
    protected final GraphController graphController;
    private javax.swing.JButton currentSpeedDisplay;
    private javax.swing.JPanel sideBarContainer;
    private javax.swing.JButton minus;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JButton plus;
    private JPanel container;
    private GraphComponent graphComponent;
    private Iterator<SearchStep<Integer>> searchIterator;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private float currentSpeed = 1.0f;
    private final DecimalFormat df = new DecimalFormat();

    public AbstractSearchView(GraphController graphController) {
        this.graphController = graphController;
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(1);

        initComponents();
    }

    protected abstract Iterator<SearchStep<Integer>> getSearchIterator();

    @SuppressWarnings("unchecked")
    private void initComponents() {
        this.setPreferredSize(new Dimension(800, 800));
        this.container = new JPanel();
        this.container.setPreferredSize(new Dimension(800, 800));
        this.container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));

        sideBarContainer = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        currentSpeedDisplay = new javax.swing.JButton();
        plus = new javax.swing.JButton();
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
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphComponent.increaseSpeed();
                if (currentSpeed < 1.9) {
                    currentSpeed += 0.1;
                }

                currentSpeedDisplay.setText(df.format(currentSpeed));
            }
        });

        sideBarContainer.add(plus);

        currentSpeedDisplay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        currentSpeedDisplay.setText("1.0");
        currentSpeedDisplay.setEnabled(false);
        currentSpeedDisplay.setFocusable(false);
        currentSpeedDisplay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sideBarContainer.add(currentSpeedDisplay);

        minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/Minus.png"))); // NOI18N
        minus.setFocusable(false);
        minus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphComponent.decreaseSpeed();

                if (currentSpeed > 0.1) {
                    currentSpeed -= 0.1;
                }

                currentSpeedDisplay.setText(df.format(currentSpeed));
            }
        });

        sideBarContainer.add(minus);


        this.add(container);

        graphComponent = new GraphComponent(graphController);

        graphComponent.setPreferredSize(new Dimension(600, 600));
        sideBarContainer.setPreferredSize(new Dimension(57, 50));
        sideBarContainer.setMaximumSize(new Dimension(57, 2000));

        container.add(graphComponent);
        container.add(sideBarContainer);
    }

    private void playActionPerformed(java.awt.event.ActionEvent evt) {
        if (isRunning.get()) {
            // search in progress, avoid overlapping searches.
            return;
        }

        isRunning.set(true);

        if (searchIterator == null || !searchIterator.hasNext()) {
            // new search, grab a new iterator object.
            this.searchIterator = this.getSearchIterator();
        }

        this.graphComponent.unpause();
        new SwingWorker() {
            @Override
            protected Void doInBackground() throws Exception {
                graphComponent.drawSearch(searchIterator);
                isRunning.set(false);
                return null;
            }
        }.execute();
    }

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {                                      
        this.graphComponent.pause();
    }
}
