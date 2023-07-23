package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Jeu jeu = new Jeu();
        jeu.distribuerCartes();
        jeu.afficherCartesEnMainDesJoueurs();

        try {
            jeu.gererUnPli();
        }catch (PasDeCartesEnMainException e ){
            System.out.println("Exception : " + e.getMessage());
        }
        jeu.afficherCartesEnMainDesJoueurs();

    }
}