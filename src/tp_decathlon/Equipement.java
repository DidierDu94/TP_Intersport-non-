/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Equipement {
    
    // Attributs
    
    private String ref;
    private String sport;
    private String nom;
    private float prix;
    private int nbExmpl;
    
    // Constructeur
    //Ajout commentaire
    public Equipement(String ref, String sport, String nom, float prix, int nbExmpl){
        this.ref = ref;
        this.sport = sport;
        this.nom = nom;
        this.prix = prix;
        this.nbExmpl = nbExmpl;
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        return ref + " " + sport + " " + nom + " " + prix + " " + nbExmpl;
    }
    public void test_A(){
        int a;
    
}
    
}



