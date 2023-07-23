package org.example;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<Carte> cartesEnMain;

    public Joueur(String nom) {
        this.nom = nom;
        this.cartesEnMain = new ArrayList<>();
    }
    public void ajouterCarteEnMain(Carte carte){
        cartesEnMain.add(carte);
    }

    // permet de rajouter à sa main la liste des cartes gagné
    public void ajouterCartesEnMain(List<Carte> cartes){
        cartesEnMain.addAll(cartes);
    }
    public String getNom(){
        return nom;
    }
    public List<Carte> getCartesEnMain(){
        return cartesEnMain;
    }

    public Carte jouerCarte() throws PasDeCartesEnMainException {
        if (cartesEnMain.isEmpty()){
            throw new PasDeCartesEnMainException("Le joueur n'a pas de carte en main");
        }
        return cartesEnMain.remove(0);
    }
    public void afficherCartesEnMain(){
        System.out.println("Cartes en main pour " + nom + ":");
        for (Carte carte : cartesEnMain){
            System.out.println(carte);
        }
        System.out.println();
    }
}
