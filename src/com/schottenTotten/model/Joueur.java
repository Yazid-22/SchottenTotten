package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private TypeJoueur type;
    private List<Carte> main;

    public Joueur(String nom, TypeJoueur type) {
        this.nom = nom;
        this.type = type;
        this.main = new ArrayList<>();
    }

    public void ajouterCarte(Carte c) {
        if (c != null) {
            this.main.add(c);
        }
    }

    public Carte retirerCarte(int i) {
        if (i < 0 || i >= main.size()) {
            throw new IllegalArgumentException("Indice de carte invalide : " + i);
        }
        return this.main.remove(i);
    }

    public List<Carte> getMain() {
        return main;
    }

    public String getNom() {
        return nom;
    }

    public TypeJoueur getType() {
        return type;
    }
}