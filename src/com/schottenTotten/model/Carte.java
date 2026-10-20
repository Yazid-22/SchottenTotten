package com.schottenTotten.model;

public class Carte {
    private int valeur;
    private Couleur couleur;

    public Carte(int valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public int getValeur() {
        return valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "[" + couleur + " " + valeur + "]";
    }
}