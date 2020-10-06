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
        //this.colors = new HashMap<>();
        this.isDirected = isDirected;
    }
    
//    public Graph(boolean isDirected, int nVertexes) {
//        this(isDirected);
//        //if (nVertexes < 5)
//            //DÁ ERRO AÍ MERMÃO
//        //else {
//            for (int i = 0; i < nVertexes; i++) {
//                addVertex(new Vertex<>(i));
//            }
//        //}
//    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
        return this.adjList;
    }

    public Iterable<Vertex<T>> getVertices() {
        return this.adjList.keySet();
    }

    public int numberOfVertices() {
        return this.adjList.size();
    }

    public Iterable<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        return this.adjList.getOrDefault(vertex, new ArrayList<>());
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
        this.adjList.put(vertex, new ArrayList<>());
//        this.colors.put(this.adjList.keySet().size(), "branco");
        return true;
    }

    public boolean addEdge(final Vertex<T> v, final Vertex<T> u) {
        if (!(this.adjList.containsKey(v)) || !(this.adjList.containsKey(u)))
            return false;
        if (this.adjList.get(v) == null)
            this.adjList.put(v, new ArrayList<>());
        if (this.adjList.get(v).contains(u))
            return false;
        this.adjList.get(v).add(u);
        return true;
    }

    public static Graph<Integer> generateRandomGraph() {
        // generate random graph using integers as vertex
        final Random random = new Random();
        final Graph<Integer> graph = new Graph<>(random.nextBoolean());
        /*
        int i;
        final int j = random.nextInt(21) + 5; //gerando entre 5 e 25 vértices aleatoriamente
        final int k = random.nextInt(626); //gerando entre 0 e 625 (25²) arestas aleatoriamente
        for (i = 0; i < j; i++)
            graph.addVertex(new Vertex<>(j));
        for (i = 0; i < k; i++) {
            graph.addEdge(new Vertex<>(random.nextInt(26)),
                    new Vertex<>(random.nextInt(26)));
        }
        */

        int nVertexes = random.nextInt(21) + 5; //Gerando entre 5 e 25 vértices aleatoriamente
        int maxEdges;

        for (int i = 0; i < nVertexes; i++) {
            graph.addVertex(new Vertex<>(i));
        }

        if (graph.isDirected()) maxEdges = (int) (nVertexes * (nVertexes - 1));
        else maxEdges = (int) (nVertexes * (nVertexes - 1) / 2);

        int nEdges = random.nextInt(maxEdges + 1);

        List<List<Vertex<Integer>>> edges = new ArrayList<>();
//        Vertex<Integer> edges[][] = new Vertex<>[maxEdges][2];

        if (graph.isDirected()) {
            for (Vertex<Integer> v : graph.adjList.keySet()) {
                for (Vertex<Integer> u : graph.adjList.keySet()) {
                    if (!(v.equals(u))) {

                        final List<Vertex<Integer>> pair = new ArrayList<>();
                        pair.add(v);
                        pair.add(u);
                        edges.add(pair);
                    }
                }
            }
        }
        else {
            for (Vertex<Integer> v : graph.adjList.keySet()) {
                for (Vertex<Integer> u : graph.adjList.keySet()) {
                    if (!(v.equals(u))) {

                        final List<Vertex<Integer>> pair1 = new ArrayList<>();
                        pair1.add(v);
                        pair1.add(u);
                        edges.add(pair1);

                        final List<Vertex<Integer>> pair2 = new ArrayList<>();
                        pair2.add(u);
                        pair2.add(v);
                        edges.add(pair2);
                    }
                }
            }
        }

        Collections.shuffle(edges);

        for (int i = 0; i < nEdges; i++) {
            final List<Vertex<Integer>> pair = edges.get(i);

            graph.addEdge(pair.get(0), pair.get(1));
        }

        return graph;
    }

    private void visitVertex(Vertex<T> vertex, Set<Vertex<T>> foundVertex, List<SearchStep<T>> searchSteps) {
        foundVertex.add(vertex);

        final List<Vertex<T>> adjacentNodes = this.adjList.get(vertex);

        searchSteps.add(new SearchStep<>(vertex, SearchState.FOUND));

        for (final Vertex<T> adjacentNode : adjacentNodes) {
            if (!foundVertex.contains(adjacentNode)) {
                this.visitVertex(adjacentNode, foundVertex, searchSteps);
            }
        }

        System.out.println();

        searchSteps.add(new SearchStep<>(vertex, SearchState.FINISHED));
    }

    public List<SearchStep<T>> dfs() {
        final Set<Vertex<T>> foundVertex = new HashSet<>();
        final List<SearchStep<T>> searchSteps = new LinkedList<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            vertex.setSearchState(SearchState.NOT_FOUND);
        }

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            if (!foundVertex.contains(vertex)) {
                visitVertex(vertex, foundVertex, searchSteps);
            }
        }

        return searchSteps;
    }

    public List<SearchStep> bfs(Vertex<T> source) {
        final Set<Vertex<T>> foundVertex = new HashSet<>();
        final List<SearchStep> searchSteps = new LinkedList<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            vertex.setSearchState(SearchState.NOT_FOUND);
        }

        final Queue<Vertex<T>> pQueue = new PriorityQueue<>();

        pQueue.offer(source);
        searchSteps.add(new SearchStep(source, SearchState.FOUND));

        while (pQueue.peek() != null) {
            final Vertex<T> vertex = pQueue.poll();
            foundVertex.add(vertex);
            for (Vertex<T> adjVertex : this.adjList.get(vertex)) {
                if (!(foundVertex.contains(adjVertex))) {
                    foundVertex.add(adjVertex);
                    pQueue.offer(adjVertex);
                    searchSteps.add(new SearchStep(adjVertex, SearchState.FOUND));
                }
            }
            searchSteps.add(new SearchStep(vertex, SearchState.FINISHED));
        }

        return searchSteps;
    }
}