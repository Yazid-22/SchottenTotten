package com.schottenTotten.model;

public class Action {
    private int indexCarteMain;
    private int indexBorne;

    public Action(int indexCarteMain, int indexBorne) {
        this.indexCarteMain = indexCarteMain;
        this.indexBorne = indexBorne;
    }

    public int getIndexCarteMain() {
        return indexCarteMain;
    }

    public int getIndexBorne() {
        return indexBorne;
    }
}