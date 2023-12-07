package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

public class LigneCommande {
    
    // Attributs
    
    private String ref;    // Référence de l'équipement : 5 caractères
    private int nbExempl;  // Nombre d'exemplaire commandés par la collectivité
    private float prixUni; // Prix unitaire de l'équipement en euros
    
    // Constructeur
    
    public LigneCommande(int nbExempl, Equipement objet){
        
        this.ref = objet.getref();
        this.nbExempl = nbExempl;
        this.prixUni = objet.getprix();   
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        return ref + " " + nbExempl + " " + prixUni;
    }
    
    // Getters
    
    public String getref(){
        return ref;
    }
    
    public int getnbExempl(){
        return nbExempl;
    }
    
    public float getprixUni(){
        return prixUni;
    }
    
    /*
    Méthode retournant sous la forme d'une chaine de caractères les 
    informations à écrire dans le fichier texte.
    */
    public String versFichier(){
        return ref + " : " + nbExempl + " : " + prixUni;
    }
    
    /*
    Méthode renvoyant true si la valeur de l'appelant est plus que celle de
    l'argument, c'est-à-dire qu'il doit être rangé après lui.
    */
    public boolean placeApres(LigneCommande autre){
        String ref_autre = autre.getref();
        int comp = ref.compareTo(ref_autre);
        return comp > 0;
    }
}
