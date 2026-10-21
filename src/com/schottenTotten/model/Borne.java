package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.List;

public class Borne {
    private List<Carte> cartesJ1;
    private List<Carte> cartesJ2;
    private int premierACompleter; // -1 : personne, 0 : J1 en premier, 1 : J2 en premier
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

        if (cote.size() == 3 && premierACompleter == -1) {
            premierACompleter = j;
        }
    }

    public boolean estPleine() {
        return cartesJ1.size() == 3 && cartesJ2.size() == 3;
    }

    // Résout la borne entre J1 (index 0) et J2 (index 1), retourne le gagnant ou null si égalité non départageable
    public Joueur evaluerEtAttribuer(Joueur j1, Joueur j2) {
        if (!estPleine()) {
            return null; // On ne peut revendiquer que si les deux côtés ont 3 cartes
        }

        Combinaison combJ1 = new Combinaison(cartesJ1);
        Combinaison combJ2 = new Combinaison(cartesJ2);

        int comparaison = combJ1.compareTo(combJ2);

        if (comparaison > 0) {
            proprietaire = j1;
        } else if (comparaison < 0) {
            proprietaire = j2;
        } else {
            // Égalité parfaite de combinaisons : c'est celui qui a complété sa borne en premier qui gagne
            if (premierACompleter == 0) {
                proprietaire = j1;
            } else if (premierACompleter == 1) {
                proprietaire = j2;
            }
        }
        return proprietaire;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public List<Carte> getCartesJ1() {
        return cartesJ1;
    }

    public List<Carte> getCartesJ2() {
        return cartesJ2;
    }
}