package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partie {
    private List<Joueur> joueurs;
    private List<Borne> bornes;
    private List<Carte> pioche;
    private int joueurActuel;

    public Partie(Joueur j1, Joueur j2) {
        this.joueurs = new ArrayList<>();
        this.joueurs.add(j1);
        this.joueurs.add(j2);

        this.bornes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            this.bornes.add(new Borne());
        }

        this.pioche = new ArrayList<>();
        initialiserPioche();

        // Distribution initiale : 6 cartes par joueur (variante de base)
        for (int i = 0; i < 6; i++) {
            j1.ajouterCarte(piocher());
            j2.ajouterCarte(piocher());
        }

        this.joueurActuel = 0;
    }

    private void initialiserPioche() {
        for (Couleur c : Couleur.values()) {
            for (int v = 1; v <= 9; v++) {
                pioche.add(new Carte(v, c));
            }
        }
        Collections.shuffle(pioche);
    }

    public Joueur getJoueurActuel() {
        return joueurs.get(joueurActuel);
    }

    public int getIndexJoueurActuel() {
        return joueurActuel;
    }

    public Carte piocher() {
        if (pioche.isEmpty()) {
            return null; // Gestion du cas où la pioche est vide
        }
        return pioche.remove(0);
    }

    public void passerJoueurSuivant() {
        this.joueurActuel = (this.joueurActuel + 1) % joueurs.size();
    }

    public List<Borne> getBornes() {
        return bornes;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }
}