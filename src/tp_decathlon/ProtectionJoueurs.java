package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

public class ProtectionJoueurs extends Joueurs{
    
    // Attribut
    
    private String niveau; // Niveau de pratique auquel l'équipement est destiné
                                    // débutant / régulier / expert
    
    // Constructeur
    
    public ProtectionJoueurs(String ref, String sport, String nom, float prix,
                    int nbExmpl, String taille, String coloris, String niveau){
        
        super(ref, sport, nom, prix, nbExmpl, taille, coloris);    
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        return super.toString() + " " + niveau;     
    }
    
    // Getter
    
    public String getniveau(){
        return niveau;
    }
    
    // Méthode retournant les informations à écrire dans le fichier en String
    
    @Override
    public String versFichier(){
        return super.versFichier() + " : " + niveau; 
    }
    
}
