package model;

import view.AbstractView;

import java.util.ArrayList;

public abstract class AbstractModel {

    private ArrayList<AbstractView> views = new ArrayList<>();

    public void attach(AbstractView view){
        views.add(view);
    }

    public void detach(AbstractView view){
        views.remove(view);
    }

}
