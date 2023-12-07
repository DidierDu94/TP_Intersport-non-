package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

public class Terrain extends Equipement{
    
    //Attributs
    
    private float hauteur;   // Hauteur (ou longueur) de l'équipement en mètres
    private float largeur;   // Largeur (ou épaisseur) de l'équipement en mètres
    private float poids;     // Masse de l'équipement en kilogrammes
    
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
    
    /*
    Méthode retournant sous la forme d'une chaine de caractères les 
    informations à écrire dans le fichier texte.
    */
    @Override
    public String versFichier(){
        return super.versFichier() + " : " + hauteur + " : " + largeur + " : " + poids;
    }
    
    /*
    Cette méthode permet de calculer le délai de livraison d'un équipement en
    fonction de la quantité restante et de son poids.
    */
    @Override
    public long calculDelai(int qte){
        long delai = 3L;
        if(!verifDispo(qte)){
            delai += 30L;
        }
        if (poids > 100){
            delai += 2L;
        }
        return delai;
    }
}
    

