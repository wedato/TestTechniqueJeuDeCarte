package org.example;

public class Carte {

    public enum Valeur {
        DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS
    }
    public enum Couleur {
        TREFLE,PIQUE,CARREAU,COEUR
    }
    private Valeur valeur;
    private Couleur couleur;

    public Carte(Valeur valeur, Couleur couleur){
        this.valeur = valeur;
        this.couleur = couleur;

    }
    public Valeur getValeur() {
        return valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public int comparerCarte(Carte autreCarte){
        return this.valeur.compareTo(autreCarte.getValeur());
    }

    @Override
    public String toString() {
        return "" + valeur + " de " + couleur + " ";
    }
}
