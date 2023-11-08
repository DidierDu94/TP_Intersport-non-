package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Joueurs extends Equipement{
    
    //Attributs
    private int taille;
    private String coloris;
    
    //Constructeurs
    public Joueurs(String ref, String sport, String nom, float prix, int nbExmpl,char taille, String coloris){
        
        super(ref,sport,nom,prix,nbExmpl);
        this.taille = taille;
        this.coloris = coloris;
          
    }
    
    
}
