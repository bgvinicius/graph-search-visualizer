package controllers;

import models.Graph;
import models.SearchStep;
import models.Vertex;

import java.util.List;

/**
 * Application controller. The controller acts as a middleware between the underlying
 * graph and the view methods. The controller also holds the current graph being used in the application.
 */
public class GraphController {

    private Graph<Integer> currentGraph;

    public GraphController() {
        this.currentGraph = Graph.generateRandomGraph();
    }

    /**
     * Adds a new edge in the current graph.
     * @param from origin vertex
     * @param to destination vertex
     * @return true if the edge was added, false otherwise
     * This method will return false only when origin or destination vertex isn't added in the graph.
     */
    public boolean addEdge(Vertex<Integer> from, Vertex<Integer> to) {
        return this.currentGraph.addEdge(from, to);
    }

    /**
     * Adds a new vertex on the graph.
     * @param vertex The vertex to add.
     */
    public void addVertex(Vertex<Integer> vertex) {
        this.currentGraph.addVertex(vertex);
    }

    /**
     * Gets an iterator on the graph vertices.
     */
    public Iterable<Vertex<Integer>> getVertices() {
        return this.currentGraph.getVertices();
    }

    /**
     * Used to read the adjacent vertices from some vertex.
     * @param vertex vertex to find adjacent vertices
     * @return iterator containg adjacent vertices from the vertex.
     */
    public Iterable<Vertex<Integer>> getAdjacentVertices(Vertex<Integer> vertex) {
        return this.currentGraph.getAdjacentVertices(vertex);
    }

    /**
     * Updates the application current graph global instance.
     */
    public void generateNewGraph() {
        this.currentGraph = Graph.generateRandomGraph();
    }

    /**
     * Clears the application current graph global instance.
     */
    public void emptyGraph(boolean isDirected) {
        this.currentGraph = new Graph<>(isDirected);
    }

    /**
     *
     * @return number of vertices in the current graph.
     */
    public int numberOfVertices() {
        return this.currentGraph.numberOfVertices();
    }

    /**
     * Return an list containing the order of DFS visits and coloring for each vertex of the current graph.
     * @return
     */
    public List<SearchStep<Integer>> getDFSSearchSequence() {
        return this.currentGraph.dfs();
    }

    /**
     * Return an list containing the order of BFS visits and coloring for each vertex of the current graph.
     * @return
     */
    public List<SearchStep<Integer>> getBFSSearchSequence(Vertex<Integer> source) {
        return this.currentGraph.bfs(source);
    }

    /**
     *
     * @return true if the graph is directed, false otherwise
     */
    public boolean isDirected() {
        return this.currentGraph.isDirected();
    }

    public boolean containsVertex(Vertex<Integer> vertex) {
        return this.currentGraph.contains(vertex);
    }
}
