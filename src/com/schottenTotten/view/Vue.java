package com.schottenTotten.view;

import com.schottenTotten.model.Action;
import com.schottenTotten.model.Partie;
import java.util.Scanner;

public class Vue {
    private Scanner scanner;

    public Vue() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherEtat(Partie p) {
        // TO DO: Afficher les 9 bornes et la main du joueur actuel
        System.out.println("--- Tour de " + p.getJoueurActuel().getNom() + " ---");
        System.out.println("Main : " + p.getJoueurActuel().getMain());
    }

    public Action demanderAction() {
        System.out.print("Indice de la carte à jouer : ");
        int idxCarte = scanner.nextInt();
        System.out.print("Indice de la borne (0-8) : ");
        int idxBorne = scanner.nextInt();
        return new Action(idxCarte, idxBorne);
    }

    public void afficherMessage(String msg) {
        System.out.println(msg);
    }
}