package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Joueurs extends Equipement{        // Super classe de ProtectionJoueurs
    
    //Attributs
    
    private String taille;              // Taille de l'équipement : 3XS / XXS / XS / S / M / M/L / L / XL / XXL / 3XL / 4XL / 5XL
    private String coloris;             // Coloris de l'équipement (ex : bleu, rouge, transparent...)
    
    //Constructeur
    
    public Joueurs(String ref, String sport, String nom, float prix, int nbExmpl, String taille, String coloris){
        
        super(ref, sport, nom, prix, nbExmpl);
        
        this.taille = taille;
        this.coloris = coloris;
          
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        
        return super.toString() + " " + taille + " " + coloris;   
    }
    
    // Getters
    
    public String gettaille(){
        return taille;
    }
    
    public String getcoloris(){
        return coloris;
    }
    
    // Autres méthodes
    
    @Override
    public String versFichier(){
        return super.versFichier() + " : " + taille + " : " + coloris;
    }
    
}
