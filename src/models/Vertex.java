package models;

public class Vertex<T> {
    private final T data;

    private SearchState searchState;

    public Vertex(T data) {
        this.data = data;
        this.searchState = SearchState.NOT_FOUND;
    }

    public SearchState getSearchState() {
        return searchState;
    }

    public void setSearchState(SearchState searchState) {
        this.searchState = searchState;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            return data.equals(((Vertex<?>) o).getData());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
