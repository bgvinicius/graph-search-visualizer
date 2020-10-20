package models;

import java.util.*;

/**
 * A graph class representing graph vertices as integers, using adjacency lists.
 */
public class Graph<T> {
    private final Map<Vertex<T>, Set<Vertex<T>>> adjList; //adjacency list

    private final boolean isDirected; //boolean indicating whether an instance is a digraph or not

    public Graph(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    /**
     *
     * @return Iterable containing all vertices of the graph.
     */
    public Iterable<Vertex<T>> getVertices() {
        return this.adjList.keySet();
    }

    public int numberOfVertices() {
        return this.adjList.size();
    }

    /**
     * Used to read the adjacent vertices from some vertex.
     * @param vertex vertex to find adjacent vertices
     * @return iterator containg adjacent vertices from the vertex.
     */
    public Iterable<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        return this.adjList.getOrDefault(vertex, new HashSet<>());
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean addVertex(Vertex<T> vertex) {
        if (this.adjList.keySet().size() >= 25)
            return false;
        this.adjList.put(vertex, new HashSet<>());
        return true;
    }

    //a method for adding an edge to a graph by giving 2 vertices, for digraphs its assumed that the first vertex is the source
    public boolean addEdge(final Vertex<T> v, final Vertex<T> u) {
        if (!(this.adjList.containsKey(v)) || !(this.adjList.containsKey(u)))
            return false;
        this.adjList.computeIfAbsent(v, k -> new HashSet<>());
        this.adjList.computeIfAbsent(u, k -> new HashSet<>());

        if (this.adjList.get(v).contains(u))
            return true;
        this.adjList.get(v).add(u);

        if (!isDirected) {
            this.adjList.get(u).add(v);
        }

        return true;
    }

    /**
     * generate a random graph using integers as vertices
     * @return The generated graph.
     */
    public static Graph<Integer> generateRandomGraph() {
        final Random random = new Random();
        final Graph<Integer> graph = new Graph<>(false);

        int nVertexes = random.nextInt(21) + 5; //Generating between 5 and 25 vertices randomly
        int maxEdges;

        for (int i = 0; i < nVertexes; i++) {
            graph.addVertex(new Vertex<>(i));
        }

        if (graph.isDirected()) //Limiting the edges based on the boolean isDirected (digraphs have double the max ammount of edges)
            maxEdges = nVertexes * (nVertexes - 1);
        else
            maxEdges = nVertexes * (nVertexes - 1) / 2;
        int nEdges = random.nextInt(maxEdges + 1);

        List<List<Vertex<Integer>>> edges = new ArrayList<>();

        // first, we compute a list of all possible edges in a complete graph (with an edge between every pair of vertices)
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

        // then, we selected n edges (random) from the shuffled edges, which produces our random edges for the graph.
        for (int i = 0; i < nEdges; i++) {
            final List<Vertex<Integer>> pair = edges.get(i);

            graph.addEdge(pair.get(0), pair.get(1));
        }

        return graph;
    }

    /**
     * a recursive method to visit a vertex and its descendants used by dfs
     * @param vertex the current vertex being visited
     * @param foundVertex a set of found vertices. This is important to avoid revisiting already found vertices.
     * @param searchSteps A list of steps representing the search, containing the order of visits and transition of colors
     *                    for each vertex.
     */
    private void visitVertex(Vertex<T> vertex, Set<Vertex<T>> foundVertex, List<SearchStep<T>> searchSteps) {
        foundVertex.add(vertex);

        final Iterable<Vertex<T>> adjacentNodes = this.adjList.get(vertex);

        searchSteps.add(new SearchStep<>(vertex, SearchState.FOUND));

        for (final Vertex<T> adjacentNode : adjacentNodes) {
            if (!foundVertex.contains(adjacentNode)) {
                this.visitVertex(adjacentNode, foundVertex, searchSteps);
            }
        }

        searchSteps.add(new SearchStep<>(vertex, SearchState.FINISHED));
    }

    //depth first search implementation
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

    /**
     * breadth first search from a source
     * @param source source vertex
     * @return A list of steps representing the search, containing the order of visits and transition of colors
     *         for each vertex.
     */
    public List<SearchStep<T>> bfs(Vertex<T> source) {
        final Set<Vertex<T>> foundVertex = new HashSet<>();
        final List<SearchStep<T>> searchSteps = new LinkedList<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            vertex.setSearchState(SearchState.NOT_FOUND);
        }

        final Queue<Vertex<T>> queue = new LinkedList<>();

        queue.offer(source);
        searchSteps.add(new SearchStep<>(source, SearchState.FOUND));

        while (queue.peek() != null) {
            final Vertex<T> vertex = queue.poll();
            foundVertex.add(vertex);
            for (Vertex<T> adjVertex : this.adjList.get(vertex)) {
                if (!(foundVertex.contains(adjVertex))) {
                    foundVertex.add(adjVertex);
                    queue.offer(adjVertex);
                    searchSteps.add(new SearchStep<>(adjVertex, SearchState.FOUND));
                }
            }
            searchSteps.add(new SearchStep<>(vertex, SearchState.FINISHED));
        }

        return searchSteps;
    }

    public boolean contains(Vertex<T> vertex) {
        return this.adjList.containsKey(vertex);
    }
}