package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Terrain extends Equipement{
    
    //Attributs
    
    private float hauteur;              // Hauteur (ou longueur) de l'équipement en mètres
    private float largeur;              // Largeur (ou épaisseur) de l'équipement en mètres
    private float poids;                // Masse de l'équipement en kilogrammes
    
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
        
        return super.toString() + " " + hauteur + " " +largeur + " " + poids;
    }
    
}
    

