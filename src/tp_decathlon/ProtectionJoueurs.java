
package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class ProtectionJoueurs extends Joueurs{
    
    //Attributs
    private String niveau_de_pratique;
    
    //Constructeurs
    public ProtectionJoueurs(String ref, String sport, String nom, float prix, int nbExmpl,String niveau_de_pratique){
        
        super(taille,coloris);
        this.niveau_de_pratique = niveau_de_pratique;
        
        
        
    }
}
