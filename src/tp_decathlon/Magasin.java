package tp_decathlon;
// @author Calmet Pierre && Bertin Pierre-Aloïs

public class Magasin {
    
    // Attributs
    
    private String nom_mag;             // Nom du magasin
    private int nbEqpmt;                // Nombre d'équipement vendus au magasin 
    private Equipement[] lstEqpmt;      // Ensemble des équipements vendus au magasin
    private int nbCmd;                  // Nombre de commandes passées depuis le magasin
    private Commande[] lstCmd;          // Ensemble des commandés passées au magasin
    
    private int cptTR;                  // Compteur spécifique pour la référence des équipements de Terrain
    private int cptJO;                  // Compteur spécifique pour la référence des équipements de Joueurs
    private int cptPR;                  // Compteur spécifique pour la référence des équipements de ProtectionJoueurs
    
    // Constructeur
    
    public Magasin(String nom_mag){
    
        this.nom_mag = nom_mag;
        
        lstEqpmt = new Equipement[1000000];
        nbEqpmt = 0;
        lstCmd = new Commande[1000000];
        nbCmd = 0;
        
        cptTR = 0;
        cptJO = 0;
        cptPR = 0;
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
    
    static public String tableau(Object[] tab){  // Méthode renvoyant une String sous forme d'un tableau en affichant un élément par ligne.
        String[] strTab = new String[tab.length];
        for (int i=0 ; i <= tab.length-1 ; i++){
            strTab[i] = tab[i].toString();       
        }
        String tabGrille = String.join("\n", strTab);
        return tabGrille;
    }
    
    public String reference(String type, int cpt){
        String nbRef;
        if (cpt<=9){
            nbRef = "00" + cpt;
        } else if (cpt<=99){
            nbRef = "0" + cpt;
        } else{
            nbRef = "" + cpt;
        }
        String ref = type + nbRef;
        return ref;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, float poids){
        String ref = reference("TR", cptTR);
        Terrain TR;
        TR = new Terrain(ref, sport, nom, prix, nbExmpl, poids);
        lstEqpmt[cptTR+cptJO+cptPR] = TR;
        cptTR += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, float hauteur, float largeur, float poids){
        String ref = reference("TR", cptTR);
        Terrain TR;
        TR = new Terrain(ref, sport, nom, prix, nbExmpl, hauteur, largeur, poids);
        lstEqpmt[cptTR+cptJO+cptPR] = TR;
        cptTR += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, String taille, String coloris){
        String ref = reference("JO", cptJO);
        Joueurs JO;
        JO = new Joueurs(ref , sport, nom, prix, nbExmpl, taille, coloris);
        lstEqpmt[cptTR+cptJO+cptPR] = JO;
        cptJO += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, String taille, String coloris, String niveau){
        String ref = reference("PR", cptPR);
        ProtectionJoueurs PR;
        PR = new ProtectionJoueurs(ref , sport, nom, prix, nbExmpl, taille, coloris, niveau);
        lstEqpmt[cptTR+cptJO+cptPR] = PR;
        cptPR += 1;
        nbEqpmt += 1;
    }
    
    
    }
    

