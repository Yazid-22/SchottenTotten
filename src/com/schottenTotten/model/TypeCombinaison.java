package com.schottenTotten.model;

public enum TypeCombinaison {
    SOMME(1),
    SUITE(2),
    COULEUR(3),
    BRELAN(4),
    SUITE_COULEUR(5);

    private final int force;

    TypeCombinaison(int force) {
        this.force = force;
    }

    public int getForce() {
        return force;
    }
}