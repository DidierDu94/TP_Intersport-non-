package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class LigneCommande {
    
    // Attributs
    
    private String ref;                 // Référence de l'équipement : 5 caractères
    private int nbExempl;               // Nombre d'exemplaire commandés par la collectivité
    private float prixUni;              // Prix unitaire de l'équipement en euros
    
    // Constructeur
    
    public LigneCommande(int nbExempl, Equipement objet){
        
        this.ref = objet.ref;
        this.nbExempl = nbExempl;
        this.prixUni = objet.prix;
        
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        
        return ref + " " + nbExempl + " " + prixUni;
    }
    
}
