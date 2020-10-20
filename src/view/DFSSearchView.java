package view;

import controllers.GraphController;
import models.SearchStep;

import java.util.Iterator;

public class DFSSearchView extends AbstractSearchView {

    public DFSSearchView(GraphController graphController) {
        super(graphController);
    }

    @Override
    protected Iterator<SearchStep<Integer>> getSearchIterator() {
        return this.graphController.getDFSSearchSequence().iterator();
    }
}
