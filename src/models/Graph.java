package models;

import java.util.*;

/**
 * A graph class representing graph vertices as integers, using adjacency lists.
 */
public class Graph<T> {
    private final Map<Vertex<T>, List<Vertex<T>>> adjList; //lista de adjacências

    //    private final HashMap<Vertex<T>, String> colors; //um dicionário que mapeia um vértice à sua cor
    private final boolean isDirected;

    private Graph(boolean isDirected) {
        this.adjList = new HashMap<>();
        //this.colors = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    public Graph(boolean isDirected, int nVertexes) {
        this(isDirected);
        //if (nVertexes < 5) 
            //DÁ ERRO AÍ MERMÃO
        //else {
            for (int i = 0; i < nVertexes; i++) {
                addVertex(new Vertex<T>(i));
            }
        //}
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
        return this.adjList;
    }

    public Set<Vertex<T>> getKeyList(){
        return adjList.keySet();
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
        if (this.adjList.get(v).contains(u))
            return false;
        if (this.adjList.get(v) == null)
            this.adjList.put(v, new ArrayList<>());
        this.adjList.get(v).add(u);
        return true;
    }

public static void generateRandomGraph() {
        // generate random graph using integers as vertex
        
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

        if (graph.isDirected()) maxEdges = (int) (nVertexes * (nVertexes - 1));
        else maxEdges = (int) (nVertexes * (nVertexes - 1) / 2);

        int nEdges = random.nextInt(maxEdges + 1);

        final Random random = new Random();
        final Graph<Integer> graph = new Graph<>(random.nextBoolean(), nVertexes);

        Vertex<Integer> edges[][] = new Vertex<Integer>[maxEdges][2];

        if (graph.isDirected()) {
            int i = 0;
            for (Vertex<Integer> v : graph.adjList.keySet()) {
                for (Vertex<Integer> u : graph.adjList.keyset()) {
                    if (!(v.equals(u))) {
                        edges[i][0] = v;
                        edges[i][1] = u;
                        i++;
                        edges[i][0] = u;
                        edges[i][1] = v;
                        i++;
                    }
                }
            }
        }
        else {
            int i = 0;
            for (Vertex<Integer> v : graph.adjList.keySet()) {
                for (Vertex<Integer> u : graph.adjList.keyset()) {
                    if (!(v.equals(u))) {
                        edges[i][0] = v;
                        edges[i][1] = u;
                        i++;
                    }
                }
            }
        }

        Util.shuffle(edges);

        for (int i = 0; i < nEdges; i++) {
            graph.addEdge(edges[i][0], edges[i][1]);
        }
    }

    private void visitVertex(Vertex<T> vertex, Set<Vertex<T>> foundVertex, Stack<Vertex<T>> currentPath, List<SearchStep> searchSteps) {
        currentPath.add(vertex);
        foundVertex.add(vertex);

        final List<Vertex<T>> adjacentNodes = this.adjList.get(vertex);

        searchSteps.add(new SearchStep(vertex, SearchState.FOUND));

        for (final Vertex<T> adjacentNode : adjacentNodes) {
            if (!foundVertex.contains(adjacentNode)) {
                this.visitVertex(adjacentNode, foundVertex, currentPath, searchSteps);
            }
        }

        for (Vertex<T> pathNodes : currentPath) {
            System.out.print(pathNodes + " -> ");
        }

        System.out.println();

        searchSteps.add(new SearchStep(vertex, SearchState.FINISHED));

        currentPath.pop();
    }

    public List<SearchStep> dfs() {
        final Set<Vertex<T>> foundVertex = new HashSet<>();
        final List<SearchStep> searchSteps = new LinkedList<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            v.setSearchState(SearchState.NOT_FOUND);
        }

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            if (!foundVertex.contains(vertex)) {
                final Stack<Vertex<T>> currentPath = new Stack<>();
                visitVertex(vertex, foundVertex, currentPath, searchSteps);
            }
        }

        return searchSteps;
    }

    public List<SearchStep> bfs(Vertex<T> source) {
        final Set<Vertex<T>> foundVertex = new HashSet<>();
        final List<SearchStep> searchSteps = new LinkedList<>();

        for (final Vertex<T> vertex : this.adjList.keySet()) {
            v.setSearchState(SearchState.NOT_FOUND);
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
            searchSteps.add(new SearchStep(vertex, FINISHED));
        }

        return searchSteps;
    }
}