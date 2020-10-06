package models;

import java.util.*;

public class SearchStep<T> {
    private final Vertex<T> vertex;
    private final SearchState prevState;
    private final SearchState currentState;

    public SearchStep(Vertex<T> vertex, SearchState state) {
        this.vertex = vertex;
        this.prevState = this.vertex.getSearchState();
        this.currentState = state;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public SearchState getPrevState() {
        return prevState;
    }

    public SearchState getState() {
        return currentState;
    }

}