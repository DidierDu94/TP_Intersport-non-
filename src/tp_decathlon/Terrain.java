package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Terrain extends Equipement{
    
    //Attributs
    
    private float hauteur;
    private float largeur;
    private float poids;
    
    //Constructeurs
    
    public Terrain(String ref, String sport, String nom, float prix, int nbExmpl, float hauteur, float largeur, float poids){
        
        super(ref, sport, nom, prix, nbExmpl);
        
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.poids = poids;
    }
    
    public Terrain(String ref, String sport, String nom, float prix, int nbExmpl, float poids){
        
        super(ref, sport, nom, prix, nbExmpl);
        
        this.poids = poids;
        
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        return ref + " " + sport + " " + nom + " " + prix + " " + nbExmpl + " " + poids;
    }
    
}
    

