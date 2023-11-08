package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Terrain extends Equipement{
    
    private float hauteur;
    private float largeur;
    private float poids;
    
    public Terrain(String ref, String sport, String nom, float prix, int nbExmpl,float hauteur, float largeur,float poids){
        
        super(ref,sport,nom,prix,nbExmpl);
        
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.poids = poids;    
    }
    
    
    }
    

