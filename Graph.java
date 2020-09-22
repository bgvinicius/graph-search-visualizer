package trabfinal;

import java.util.*;

public class Graph {
    private final HashMap<Integer, ArrayList<Integer>> adjList; //lista de adjacências
    private final HashMap<Integer, String> colors; //um dicionário que mapeia um vértice à sua cor

    public Graph() {
        this.adjList = new HashMap<>();
        this.colors = new HashMap<>();
    }

    public HashMap getAdjList() {
        return this.adjList;
    }

    public HashMap getColors() {
        return this.colors;
    }

    public boolean addVertex() {
        if (this.adjList.keySet().size() >= 25)
            return false;
        this.adjList.put(this.adjList.keySet().size(), null);
        this.colors.put(this.adjList.keySet().size(), "branco");
        return true;
    }

    public boolean addEdge(final int v, final int u) {
        if (!(this.adjList.containsKey(v)) || !(this.adjList.containsKey(u)))
            return false;
        if (this.adjList.get(v) == null)
            this.adjList.put(v, new ArrayList<Integer>());
        this.adjList.get(v).add(u);
        return true;
    }

    public void generateRandomGraph() {
        final Random random = new Random();
        int i;
        final int j = random.nextInt(21) + 5; //gerando entre 5 e 25 vértices aleatoriamente
        final int k = random.nextInt(626); //gerando entre 0 e 625 (25²) arestas aleatoriamente
        for (i = 0; i < j; i++)
            addVertex();
        for (i = 0; i < k; i++) {
            addEdge(random.nextInt(26), random.nextInt(26));
        }
    }
}