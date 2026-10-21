package com.schottenTotten.model;

import java.util.ArrayList;
import java.util.List;

public class Combinaison implements Comparable<Combinaison> {
    private List<Carte> cartes;
    private TypeCombinaison type;
    private int sommeValeurs;

    public Combinaison(List<Carte> cartes) {
        if (cartes == null || cartes.size() != 3) {
            throw new IllegalArgumentException("Une combinaison de Schotten-Totten doit contenir exactement 3 cartes.");
        }
        this.cartes = new ArrayList<>(cartes);
        
        // Trier les cartes par valeur croissante pour analyser facilement les suites
        this.cartes.sort((c1, c2) -> Integer.compare(c1.getValeur(), c2.getValeur()));
        
        this.sommeValeurs = this.cartes.stream().mapToInt(Carte::getValeur).sum();
        this.type = evaluerType();
    }

    private TypeCombinaison evaluerType() {
        boolean memeCouleur = (cartes.get(0).getCouleur() == cartes.get(1).getCouleur()) &&
                              (cartes.get(1).getCouleur() == cartes.get(2).getCouleur());

        int v1 = cartes.get(0).getValeur();
        int v2 = cartes.get(1).getValeur();
        int v3 = cartes.get(2).getValeur();

        boolean suiteConsecutive = (v2 == v1 + 1) && (v3 == v2 + 1);
        boolean brelan = (v1 == v2) && (v2 == v3);

        if (memeCouleur && suiteConsecutive) return TypeCombinaison.SUITE_COULEUR;
        if (brelan) return TypeCombinaison.BRELAN;
        if (memeCouleur) return TypeCombinaison.COULEUR;
        if (suiteConsecutive) return TypeCombinaison.SUITE;
        return TypeCombinaison.SOMME;
    }

    @Override
    public int compareTo(Combinaison autre) {
        // 1. Comparer d'abord la force du type de combinaison (ex: Brelan > Suite)
        int cmpType = Integer.compare(this.type.getForce(), autre.type.getForce());
        if (cmpType != 0) {
            return cmpType;
        }
        // 2. Si c'est le même type, départager par la somme des valeurs des cartes
        return Integer.compare(this.sommeValeurs, autre.sommeValeurs);
    }

    public TypeCombinaison getType() {
        return type;
    }

    public int getSommeValeurs() {
        return sommeValeurs;
    }

    @Override
    public String toString() {
        return type + " (Somme: " + sommeValeurs + ") avec " + cartes;
    }
}