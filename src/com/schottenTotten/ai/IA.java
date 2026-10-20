package com.schottenTotten.ai;

import com.schottenTotten.model.Action;
import com.schottenTotten.model.Partie;
import java.util.Random;

public class IA {
    private Random random;

    public IA() {
        this.random = new Random();
    }

    public Action choisirAction(Partie p) {
        int nbCartes = p.getJoueurActuel().getMain().size();
        int idxCarte = random.nextInt(nbCartes);
        int idxBorne = choisirBorne(p);
        return new Action(idxCarte, idxBorne);
    }

    public int choisirBorne(Partie p) {
        // TO DO: Filtrer pour ne choisir qu'une borne qui a moins de 3 cartes
        return random.nextInt(9);
    }
}