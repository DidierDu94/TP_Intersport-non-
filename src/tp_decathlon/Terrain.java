package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

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
    
    // Getters
    
    public float gethauteur(){
        return hauteur;
    }
    
    public float getlargeur(){
        return largeur;
    }
    
    public float getpoids(){
        return poids;
    }
    
    // Méthode retournant les informations à écrire dans le fichier en String
    
    @Override
    public String versFichier(){
        return super.versFichier() + " : " + hauteur + " : " + largeur + " : " + poids;
    }
}
    

