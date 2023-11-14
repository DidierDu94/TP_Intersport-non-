package tp_decathlon;
import java.util.Scanner;
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
    
    static public String tableau(Object[] tab){  // Méthode renvoyant une String sous forme d'un tableau en affichant un élément par ligne.
        String[] strTab = new String[tab.length];
        for (int i=0 ; i <= tab.length-1 ; i++){
            strTab[i] = tab[i].toString();       
        }
        String tabGrille = String.join("\n", strTab);
        return tabGrille;
    }
    
    // Ajout d'un équipement  pour un terrain (2 cas) et protections des joueurs
    
    public Terrain ajout_Terr(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quel est le nom du sport ? ");
        String sport = sc.nextLine();
        System.out.println("Que voulez-vous acheter ? ");
        //sc.nextLine();
        String designation = sc.nextLine();
        
        System.out.println("Quel est son prix ? ");
        float prix = sc.nextFloat();
        System.out.println("Combien en voulez-vous ? ");
        int nbExmpl = sc.nextInt();
        System.out.println("Quel est son poids ? ");
        float poids = sc.nextFloat();
        
        Terrain T;
        
        T = new Terrain("TR100",sport,designation,prix,nbExmpl,poids);
        return T;       
    }
    
    public Terrain ajout_Terr_Size(String ref, String sport, String designation, float prix,int nbExmpl,float poids){
        
        Scanner scan = new Scanner( System.in);
        
        System.out.println("Quelle est la hauteur du terrain ?");
        int haut = scan.nextInt();
        System.out.println("Quelle est sa largeur ? ");
        int larg = scan.nextInt();
        
        Terrain T_size;
        T_size =  new Terrain("TR200",sport,designation,prix,nbExmpl,poids,haut,larg);
        
        return T_size;      
    }
    
    public ProtectionJoueurs ajout_PJ(){
        
        
    }
    
    
    
    
    
    }
    

