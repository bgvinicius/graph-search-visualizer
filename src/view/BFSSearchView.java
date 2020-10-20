package view;

import controllers.GraphController;
import models.SearchStep;
import models.Vertex;

import javax.swing.*;
import java.util.Iterator;

public class BFSSearchView extends AbstractSearchView {
    private final Vertex<Integer> source;

    public BFSSearchView(GraphController graphController, Vertex<Integer> source) {
        super(graphController);

        this.source = source;
    }

    @Override
    protected Iterator<SearchStep<Integer>> getSearchIterator() {
        return this.graphController.getBFSSearchSequence(source).iterator();
    }
}
