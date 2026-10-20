package com.schottenTotten;

import com.schottenTotten.ai.IA;
import com.schottenTotten.controller.Controleur;
import com.schottenTotten.model.*;
import com.schottenTotten.view.Vue;

public class Main {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Joueur 1", TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("Bot", TypeJoueur.IA);

        Partie partie = new Partie(j1, j2);
        Vue vue = new Vue();
        IA ia = new IA();

        Controleur controleur = new Controleur(partie, vue, ia);
        controleur.demarrer();
    }
}