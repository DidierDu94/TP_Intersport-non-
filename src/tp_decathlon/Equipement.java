package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

import java.time.LocalDate;
import java.util.Scanner;

public class Equipement {        // Classe mère
    
    // Attributs
    
    private String ref;        // Référence de l'équipement : 5 caractères
    private String sport;
    private String nom;       // Désignation
    private float prix;      // Prix unitaire de l'équipement en euros
    private int nbExmpl;    // Nombre d'exemplaire de l'équipement en stock
    
    // Constructeur
    
    public Equipement(String ref, String sport, String nom, float prix,
            int nbExmpl){
        
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
    
    // Getters
    
    public String getref(){
        return ref;
    }
    
    public String getsport(){
        return sport;
    }
    
    public String getnom(){
        return nom;
    }
    
    public float getprix(){
        return prix;
    }
    
    public int getnbExmpl(){
        return nbExmpl;
    }
    
    public void majDispo(int qte){
        nbExmpl += qte;
    }
    
    public boolean verifDispo(int qte){
        
        if (nbExmpl>qte){
            return true;   
        }
        else if (nbExmpl>qte){
            return false;
        }
    return true;     
    }
    
    // Setter
    
    public void setnbExmpl(int setVal){
        nbExmpl = setVal;
    }
    
    /*
    Méthode permettant de mettre dans l'ordre les équipements
    en comparant leur référence.
    */
    
    public boolean placeApres(Equipement autre){
        String ref_autre = autre.getref();
        int comp = ref.compareTo(ref_autre);
        return comp > 0;
    }
    
    /*
    Méthode retournant sous la forme d'une chaine de caractères les 
    informations à écrire dans le fichier texte.
    */
    
    public String versFichier(){
        return ref + System.lineSeparator() + sport + " : " + nom + " : " 
               + prix + " : " + nbExmpl;
    }   
}
