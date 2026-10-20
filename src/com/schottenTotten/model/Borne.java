package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.List;

public class Borne {
    private List<Carte> cartesJ1;
    private List<Carte> cartesJ2;
    private int premierACompleter; // -1 par défaut, 0 pour J1, 1 pour J2
    private Joueur proprietaire;

    public Borne() {
        this.cartesJ1 = new ArrayList<>();
        this.cartesJ2 = new ArrayList<>();
        this.premierACompleter = -1;
        this.proprietaire = null;
    }

    public void poserCarte(int j, Carte c) {
        List<Carte> cote = (j == 0) ? cartesJ1 : cartesJ2;
        if (cote.size() >= 3) {
            throw new IllegalStateException("Cette borne a déjà 3 cartes pour ce joueur.");
        }
        cote.add(c);

        // Si ce joueur atteint 3 cartes et que personne ne l'avait encore fait
        if (cote.size() == 3 && premierACompleter == -1) {
            premierACompleter = j;
        }
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void attribuerA(Joueur j) {
        this.proprietaire = j;
    }

    public List<Carte> getCartesJ1() {
        return cartesJ1;
    }

    public List<Carte> getCartesJ2() {
        return cartesJ2;
    }

    public int getPremierACompleter() {
        return premierACompleter;
    }
}