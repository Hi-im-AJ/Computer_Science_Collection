package main.mvvm.model;

import java.util.Observable;

public class MainModel extends Observable {
    private String headerText = "welcome";

    public String getHeader() {
        return headerText;
    }

    public void setHeader(String text) {
        this.headerText = text;

        super.setChanged();
        super.notifyObservers();
    }
}
