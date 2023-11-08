package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Equipement {       // Classe mère
    
    // Attributs
    
    protected String ref;
    protected String sport;
    protected String nom;
    protected float prix;
    protected int nbExmpl;
    
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
   
    
}
