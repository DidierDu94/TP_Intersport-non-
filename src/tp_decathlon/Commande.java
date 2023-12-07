package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

import java.time.LocalDate;

public class Commande{
    
    // Attributs
    
    private String numero;              // Numéro de la commande : 8 caractères
    private String email;               // Adresse mail de la collectivité qui a passé commande
    private LocalDate emission;         // Date d’émission de la commande
    private LocalDate livraison;        // Date de livraison prévue
    private float total;                // Coût total de la commande en euros
    private LigneCommande[] lignes;     // Tableau contenant les différentes lignes de la commande
    private int nbLignes;               // Nombre de lignes de commande dans le tableau lignes
    
    // Constructeur
    
    public Commande(String numero, String email, LocalDate emission, LocalDate livraison, LigneCommande[] lignes){
        
        this.numero = numero;
        this.email = email;
        this.emission = emission;
        this.livraison = livraison;
        while(emission.isAfter(livraison)){
            System.out.println("La date est incorrecte !");
        }
        float total = 0.0f;
        for (int i=0;i<=lignes.length-1;i++){
            if (lignes[i] == null){
                break;
            }
            total += lignes[i].getprixUni() * lignes[i].getnbExempl();
        }
        this.total = total;
        this.lignes = lignes;
        nbLignes = 0;
        for(int i=0;i<lignes.length;i++){
            if(lignes[i] == null){
                break;
            }
            nbLignes++;
        }        
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        String tabLignes = Magasin.tableau(lignes);
        return numero + " " + email + " " + emission + " " + livraison 
               + " " + total + "\n" + tabLignes;
    }
    
    // Getters
    
    public String getnumero(){
        return numero;
    }
    
    public String getemail(){
        return email;
    }
    
    public LocalDate getemission(){
        return emission;
    }
    
    public LocalDate getlivraison(){
        return livraison;
    }
    
    public float gettotal(){
        return total;
    }
    
    public LigneCommande[] getlignes(){
        return lignes;
    }
    
    /*
    Méthode retournant sous la forme d'une chaine de caractères les 
    informations à écrire dans le fichier texte.
    */
    
    public String versFichier(){
        return numero + System.lineSeparator() + email + " : " + emission + " : " + livraison + " : " + total + System.lineSeparator() + nbLignes;
    }
    
    public boolean placeApres(Commande autre){
        int ref_autre = Integer.valueOf(autre.getnumero());
        int intRef = Integer.valueOf(numero);
        return intRef > ref_autre;
    }
    
}
