package com.schottenTotten.controller;

import com.schottenTotten.ai.IA;
import com.schottenTotten.model.*;
import com.schottenTotten.view.Vue;

public class Controleur {
    private Partie partie;
    private Vue vue;
    private IA ia;

    public Controleur(Partie partie, Vue vue, IA ia) {
        this.partie = partie;
        this.vue = vue;
        this.ia = ia;
    }

    public void demarrer() {
        vue.afficherMessage("Début de la partie de Schotten-Totten !");
        // Exemple d'un premier tour pour tester :
        vue.afficherEtat(partie);
        Joueur courant = partie.getJoueurActuel();
        Action action = (courant.getType() == TypeJoueur.HUMAIN)
                ? vue.demanderAction()
                : ia.choisirAction(partie);
        jouerTour(action);
    }

    public void jouerTour(Action a) {
        Joueur courant = partie.getJoueurActuel();
        int indexJoueur = partie.getIndexJoueurActuel();

        Carte carteJouee = courant.retirerCarte(a.getIndexCarteMain());
        partie.getBornes().get(a.getIndexBorne()).poserCarte(indexJoueur, carteJouee);

        Carte nouvelleCarte = partie.piocher();
        courant.ajouterCarte(nouvelleCarte);

        partie.passerJoueurSuivant();
    }

    public boolean verifierVictoire() {
        return false;
    }
}