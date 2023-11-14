package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Magasin {
    
    // Attributs
    
    private String nom_mag;             // Nom du magasin
    private int nbEqpmt;                // Nombre d'équipement vendus au magasin 
    private Equipement[] lstEqpmt;      // Ensemble des équipements vendus au magasin
    private int nbCmd;                  // Nombre de commandes passées depuis le magasin
    private Commande[] lstCmd;          // Ensemble des commandés passées au magasin
    
    // Constructeur
    
    public Magasin(String nom_mag, Equipement[] lstEqpmt, Commande[] lstCmd){
    
        this.nom_mag = nom_mag;
        this.lstEqpmt = lstEqpmt;
        this.nbEqpmt = lstEqpmt.length;
        this.lstCmd = lstCmd;
        this.nbCmd = lstCmd.length;
          
    }
    
    // Méthode toString()
    
    @Override
    public String toString(){
        String tabEqpmt = tableau(lstEqpmt);
        String tabCmd = tableau(lstCmd);
        return nom_mag + "\n" + "Liste des équipements vendus :" + "\n" + tabEqpmt + "\n"
                + "Liste des commandes passées au magasin :" + "\n" + tabCmd ;
    }
    
    // Getters
    
    public String getnom_mag(){
        return nom_mag;
    }
    
    public int getnbEqpmt(){
        return nbEqpmt;
    }
    
    public Equipement[] getlstEqpmt(){
        return lstEqpmt;
    }
    
    public int getnbCmd(){
        return nbCmd;
    }
    
    public Commande[] getlstCmd(){
    return lstCmd;
    }
    
    // Autres méthodes
    
    static public String tableau(Object[] tab){
        String[] strTab = new String[tab.length];
        for (int i=0 ; i <= tab.length-1 ; i++){
            strTab[i] = tab[i].toString();
        }
        String tabGrille = String.join("\n", strTab);
        return tabGrille;
    }
    
}
