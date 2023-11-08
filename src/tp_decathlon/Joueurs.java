package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Joueurs extends Equipement{        // Super classe de ProtectionJoueurs
    
    //Attributs
    
    protected String taille;
    protected String coloris;
    
    //Constructeur
    
    public Joueurs(String ref, String sport, String nom, float prix, int nbExmpl, String taille, String coloris){
        
        super(ref, sport, nom, prix, nbExmpl);
        
        this.taille = taille;
        this.coloris = coloris;
          
    }
    
    // Méthode toString()
    
}
