package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Magasin {
    
    // Attributs
    
    private String nom_mag;                 // Nom du magasin
    private final int nbEqpmt = 500;    // Nombre d'équipement vendus au magasin 
    private String[] lstEqpmt;          // Ensemble des équipements vendus au magasin
    private final int nbCmd = 500;      // Nombre de commandes passées depuis le magasin
    private String[] lstCmd;            // Ensemble des commandés passées au magasin
    
    // Constructeur
    
    public Magasin(String nom_mag, int nbEqpmt, String[] lstEqpmt, int nbCmd, String[] lstCmd){
    
        this.nom_mag = nom_mag;
        this.lstEqpmt = lstEqpmt;
        this.lstCmd = lstCmd;
          
    }
    
    public String toString(){
        
        
        
        return nom_mag + " " + lstEqpmt + " " + lstCmd ;
    }
    
}
