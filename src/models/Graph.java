package models;

import java.util.*;

/**
 * A graph class representing graph vertices as integers, using adjacency lists.
 */
public class Graph<T> {
    private final Map<Vertex<T>, List<Vertex<T>>> adjList; //lista de adjacências

    //    private final HashMap<Vertex<T>, String> colors; //um dicionário que mapeia um vértice à sua cor
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.adjList = new HashMap<>();
//        this.colors = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
        return this.adjList;
    }

//    public HashMap getColors() {
//        return this.colors;
//    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean addVertex(Vertex<T> vertex) {
        if (this.adjList.keySet().size() >= 25)
            return false;
        this.adjList.put(vertex, null);
//        this.colors.put(this.adjList.keySet().size(), "branco");
        return true;
    }

    public boolean addEdge(final Vertex<T> v, final Vertex<T> u) {
        if (!(this.adjList.containsKey(v)) || !(this.adjList.containsKey(u)))
            return false;
        if (this.adjList.get(v) == null)
            this.adjList.put(v, new ArrayList<>());
        this.adjList.get(v).add(u);
        return true;
    }

    public static void generateRandomGraph() {
        // generate random graph using integers as vertex
        final Random random = new Random();
        final Graph<Integer> graph = new Graph<>(random.nextBoolean());
        int i;
        final int j = random.nextInt(21) + 5; //gerando entre 5 e 25 vértices aleatoriamente
        final int k = random.nextInt(626); //gerando entre 0 e 625 (25²) arestas aleatoriamente
        for (i = 0; i < j; i++)
            graph.addVertex(new Vertex<>(j));
        for (i = 0; i < k; i++) {
            graph.addEdge(new Vertex<>(random.nextInt(26)),
                    new Vertex<>(random.nextInt(26)));
        }
    }

    private void visitVertex(Vertex<T> vertex, Set<Vertex<T>> foundVertex, Stack<Vertex<T>> currentPath) {
        currentPath.add(vertex);
        foundVertex.add(vertex);

        final List<Vertex<T>> adjacentNodes = this.adjList.get(vertex);

        for (final Vertex<T> adjacentNode : adjacentNodes) {
            if (!foundVertex.contains(adjacentNode)) {
                this.visitVertex(adjacentNode, foundVertex, currentPath);
            }
        }

        for (Vertex<T> pathNodes : currentPath) {
            System.out.print(pathNodes + " -> ");
        }

        System.out.println();

        currentPath.pop();
    }

    public void dfs() {
        final Set<Vertex<T>> foundVertex = new HashSet<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            if (!foundVertex.contains(vertex)) {
                final Stack<Vertex<T>> currentPath = new Stack<>();
                visitVertex(vertex, foundVertex, currentPath);
            }
        }
    }
}