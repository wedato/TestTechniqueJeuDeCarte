package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jeu {
    ArrayList<Carte> jeuDeCartes;
    ArrayList<Joueur> joueurs;

    public Jeu() {
        jeuDeCartes = new ArrayList<>();
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            for (Carte.Valeur valeur : Carte.Valeur.values()) {
                jeuDeCartes.add(new Carte(valeur, couleur));
            }
        }
        // Création des joueurs
        joueurs = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            joueurs.add(new Joueur("Joueur " + i));
        }
    }

    public void distribuerCartes() {
        Collections.shuffle(jeuDeCartes);
        int joueurActuel = 0;
        //distribution des cartes
        for (Carte carte : jeuDeCartes) {
            Joueur joueurCourant = joueurs.get(joueurActuel);
            joueurCourant.ajouterCarteEnMain(carte);

            //Passer au joueur suivant
            joueurActuel = (joueurActuel + 1) % 4;
        }
    }

    public void gererUnPli() throws PasDeCartesEnMainException {
        ArrayList<Carte> pli = new ArrayList<>();
        Carte carteLaPlusForte = null;
        List<Joueur> joueursExaequo = new ArrayList<>();
        Joueur joueurGagnant = null;

        for (Joueur joueur : joueurs) {
            Carte carteJouee = joueur.jouerCarte();
            if (carteJouee != null) {
                pli.add(carteJouee);
                System.out.println(joueur.getNom() + " joue : " + carteJouee);
                if (carteLaPlusForte == null || carteJouee.comparerCarte(carteLaPlusForte) > 0) {
                    carteLaPlusForte = carteJouee;
                    joueurGagnant = joueur; // mise a jour du joueur gagnant
                    joueursExaequo.clear();
                } else if (carteJouee.comparerCarte(carteLaPlusForte) == 0) {
                    joueursExaequo.add(joueur);

                }

            }
        }

        // si on a un cas de ex-aequo on choisit aléatoirement le joueur vainqueur
        if (joueursExaequo.size() >= 2) {
            int indexVainqueur = (int) (Math.random()) * joueursExaequo.size();
            joueurGagnant = joueursExaequo.get(indexVainqueur);
        }
        if (joueurGagnant != null) {
            joueurGagnant.ajouterCartesEnMain(pli);
            System.out.println("Le joueur " + joueurGagnant.getNom() + " remporte le pli !");
        }
    }


        public void afficherCartesEnMainDesJoueurs() {
            for (Joueur joueur : joueurs) {
                joueur.afficherCartesEnMain();
            }
        }
    }

