package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

import java.time.LocalDate;
import java.util.Scanner;

// TDTP3: Vente d'équipements sportifs

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
        
        Scanner sc = new Scanner(System.in);
        String c;
        System.out.println("Voulez-vous rajouter/retirer cette quantité à votre liste d'équipement  a/r");
        c = sc.nextLine();
        
        while (!c.equals(null)){
        
            if (!c.equals("a") || !c.equals("r")){
                break;
            }
        
            else if (c.equals("a")){
                nbExmpl += qte;
            }
            
            else{
                nbExmpl -= qte;    
            }
        }    
    }
    
    
    
    // Setter
    
    public void setnbExmpl(int setVal){
        nbExmpl = setVal;
    }
    
    // Méthode permettant d'ajouter un nouvel équipement à la fin du tableau
    
    public boolean placeApres(Equipement autre){
        String ref_autre = autre.getref();
        int comp = ref.compareTo(ref_autre);
        return comp > 0;
    }
    
    // Méthode retournant les informations à écrire dans le fichier en String
    
    public String versFichier(){
        return ref + System.lineSeparator() + sport + " : " + nom + " : " 
                + prix + " : " + nbExmpl;
    }
    
}
