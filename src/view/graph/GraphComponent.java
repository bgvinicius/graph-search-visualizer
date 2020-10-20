package view.graph;

import controllers.GraphController;
import models.SearchState;
import models.SearchStep;
import models.Vertex;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A JPanel which draws a graph.
 * The purpose of this component is to be reused on other screens.
 * This class is both able to render the graph and also to animate a search on it, given a sequence of search steps.
 */
public class GraphComponent extends JPanel {
    private final GraphController graphController;
    private final List<VertexComponent> vertices = new ArrayList<>();
    private Map<Vertex<Integer>, VertexComponent> vertexToVertexComponent;
    private AtomicBoolean isSearchPaused = new AtomicBoolean(false);
    // animation delay for each search step. Decreasing this makes search faster / incresing this makes search slower.
    private int searchStepDelay = 1000;

    private final int MIN_SEARCH_STEP_DELAY = 100;

    public GraphComponent(GraphController graphController) {
        this.setPreferredSize(new Dimension(600, 600));
        this.graphController = graphController;

        initialize();
    }

    /**
     * Initializes internal fields. This method has been set as "public" because updates on the graph (via controller)
     * don't reflect in the internal state of this class, so we make it public allowing classes to update the internal
     * state of the graph component view.
     */
    public void initialize() {
        // number of vertices in the current graph
        final int numberOfVertices = graphController.numberOfVertices();
        final Iterable<Vertex<Integer>> verticesList = graphController.getVertices();
        final Iterator<Vertex<Integer>> vertexIterator = verticesList.iterator();

        final double[][] coordenadas = generateCoordinates(numberOfVertices);

        vertexToVertexComponent = new HashMap<>();

        // scale & reposition points to fit well in the screen
        for (int i = 0; i < numberOfVertices; i++) {
            double x = (coordenadas[0][i] * 200d) + 325d;
            double y = (coordenadas[1][i] * 200d) + 325d;
            final Vertex<Integer> currentVertex = vertexIterator.next();
            final VertexComponent component = new VertexComponent((int) x, (int) y, currentVertex, graphController.isDirected());

            vertices.add(component);
            vertexToVertexComponent.put(currentVertex, component);
        }

        for (VertexComponent vertexComponent : vertices) {
            final Vertex<Integer> currentVertex = vertexComponent.getVertex();
            final Iterable<Vertex<Integer>> adjacentVertices = this.graphController.getAdjacentVertices(currentVertex);

            for (Vertex<Integer> adjacentVertex : adjacentVertices) {
                vertexComponent.addAdjacentVertex(vertexToVertexComponent.get(adjacentVertex));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (VertexComponent vertex : this.vertices) {
            vertex.drawEdges(g);
        }

        for (VertexComponent vertex : this.vertices) {
            vertex.draw(g);
        }
    }

    public void increaseSpeed() {
        if (this.searchStepDelay == MIN_SEARCH_STEP_DELAY) {
            return;
        }

        this.searchStepDelay -= 100;
    }

    public void decreaseSpeed() {
        this.searchStepDelay += 100;
    }

    public void unpause() {
        this.isSearchPaused.set(false);
    }

    public void pause() {
        this.isSearchPaused.set(true);
    }

    /**
     * Makes a search animation on the graph, given a sequence of search steps (which is a transition of color for some vertex)
     * This method is affected by two things:
     * - pauses.
     * If the search is "paused", the current execution of this method is stopped and the method must be called later with the SAME
     * iterator in order to finish the animation.
     * - search step delay
     * In order to produce the animation-like effected, we perform a little "sleep" between each iteration,
     * and this time may be changed during execution.
     * @param searchSequence an iterator to be consumed by the search. Once the iterator is fully consumed, the
     *                       graph is recolored white.
     */
    public void drawSearch(Iterator<SearchStep<Integer>> searchSequence) {
        for (; searchSequence.hasNext(); ) {
            if (isSearchPaused.get()) {
                // search has been paused. We'll stop for now and resume later, with the same iterator object.
                return;
            }

            SearchStep<Integer> step = searchSequence.next();

            final Vertex<Integer> vertex = step.getVertex();
            final VertexComponent vertexComponent = vertexToVertexComponent.get(vertex);

            if (step.getState() == SearchState.FOUND) {
                vertexComponent.draw(this.getGraphics(), Color.GRAY, Color.WHITE);
            } else {
                // search state = finished
                vertexComponent.draw(this.getGraphics(), Color.BLACK, Color.WHITE);
            }

            try {
                Thread.sleep(searchStepDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (VertexComponent vertex : vertices) {
            vertex.draw(this.getGraphics());
        }
    }

    /**
     * Generates coordinates for the graph vertices, as a n-vertices geometric figure.
     * @param n number of vertices in the graph
     * @return 2 dimension array, where first key is x or y attribute of the point, and second key is the respective
     * vertex.
     */
    public static double[][] generateCoordinates(int n) {
        double[][] coordenadas = new double[2][n];
        double x,y,ang, r = 1;

        for (int i = 0; i < n; i++) {
            ang = (((360d / n) * i) * Math.PI / 180);
            x = r * Math.cos(ang);
            y = r * Math.sin(ang);

            if (Math.abs(x) < Math.pow(10, -5))
                x = 0;
            if (Math.abs(y) < Math.pow(10, -5))
                y = 0;
            coordenadas[0][i] = x;
            coordenadas[1][i] = y;
        }

        return coordenadas;
    }
}
