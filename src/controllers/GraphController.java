package controllers;

public class GraphController {
    Graph g = new Graph();

    Vertex getVertex(){
        return g.Vertex;
    }

    getEdges(){
        return g.adjList;
    }

    private void insertVertex(Vertex v){     
        if(g.addVertex(v);){
            System.out.println("Vertex add successfully");
        }else{
            System.out.println("Error, vertex not add");
        }        
    }

    private void insertEdges(Vertex v, Vertex u){
        if(g.addEdges(v, u)){
            System.out.println("Edge add successfully");
        }else{
            System.out.println("Error, edge not add");
        }        
    }
}
