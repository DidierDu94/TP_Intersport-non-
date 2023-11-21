package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

import java.time.LocalDate;


public class Commande{
    
    // Attributs
    
    private String numero;              // Numéro de la commande : 8 caractères
    private String email;               // Adresse mail de la collectivité qui a passé commande
    private LocalDate emission;         // Date d’émission de la commande
    private LocalDate livraison;        // Date de livraison prévue
    private float total;                // Coût total de la commande en euros
    private LigneCommande[] lignes;     // Tableau contenant les différentes lignes de la commande
    
    // Constructeur
    
    public Commande(String numero, String email, LocalDate livraison, LigneCommande[] lignes){
        
        this.numero = numero;
        this.email = email;
        this.emission = LocalDate.now();
        this.livraison = livraison;
        while(!livraison.isAfter(emission)){
            System.out.println("La date est incorrecte !");
        }
        float total = 0.0f;
        for (int i=0;i<=lignes.length-1;i++){
            total += lignes[i].getprixUni() * lignes[i].getnbExempl();
        }
        this.total = total;
        this.lignes = lignes;
        
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        String tabLignes = Magasin.tableau(lignes);
        return numero + " " + email + " " + emission + " " + livraison + " " + total + "\n" + tabLignes;
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
    
    // Autres méthodes
    
    public String versFichier(){
        return numero + System.lineSeparator() + " : " + email + " : " + emission + " : " + livraison + " : " + total + System.lineSeparator() + lignes.length;
    }
    
}
