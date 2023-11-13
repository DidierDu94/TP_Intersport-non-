package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Equipement {       // Classe mère
    
    // Attributs
    
    private String ref;                 // Référence de l'équipement : 5 caractères
    private String sport;
    private String nom;                 // Désignation
    private float prix;                 // Prix unitaire de l'équipement en euros
    private int nbExmpl;                // Nombre d'exemplaire de l'équipement en stock
    
    // Constructeur
    
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
    
    public boolean placeApres(Equipement otherEquipement){ // On veut retourner un boolean selon l'emplacement de l'équipement dans la liste. Sa place est choisie avec sa référence
        
        // Equipement.ref.compareTo(otherEquipement.ref)>0;
        return true;
        //return false;    
    }
   
    
}
