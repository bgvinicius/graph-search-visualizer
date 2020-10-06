package controllers;

import models.Graph;
import models.SearchStep;
import models.Vertex;

import java.util.List;

public class GraphController {

    private Graph<Integer> currentGraph;

    public GraphController() {
        this.currentGraph = Graph.generateRandomGraph();
    }

    public void addEdge(Vertex<Integer> from, Vertex<Integer> to) {
        this.currentGraph.addEdge(from, to);
    }

    public void addVertex(Vertex<Integer> vertex) {
        this.currentGraph.addVertex(vertex);
    }

    public Iterable<Vertex<Integer>> getVertices() {
        return this.currentGraph.getVertices();
    }

    public Iterable<Vertex<Integer>> getAdjacentVertices(Vertex<Integer> vertex) {
        return this.currentGraph.getAdjacentVertices(vertex);
    }

    public void generateNewGraph() {
        this.currentGraph = Graph.generateRandomGraph();
    }

    public void emptyGraph(boolean isDirected) {
        this.currentGraph = new Graph<>(isDirected);
    }

    public int numberOfVertices() {
        return this.currentGraph.numberOfVertices();
    }

    public List<SearchStep<Integer>> getSearchSequence() {
        return this.currentGraph.dfs();
    }

    public boolean isDirected() {
        return this.currentGraph.isDirected();
    }
}
