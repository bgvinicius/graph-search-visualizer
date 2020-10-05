package models;

import java.util.*;

public class SearchStep {
    private final Vertex<T> vertex;
    private final SearchState prevState;

    public SearchStep(Vertex<T> vertex, SearchState state) {
        this.vertex = vertex;
        this.prevState = this.vertex.getState();
        this.vertex.setSearchState(state);
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public SearchState getPrevState() {
        return prevState;
    }

    public SearchState getState() {
        return vertex.getSearchState();
    }

}