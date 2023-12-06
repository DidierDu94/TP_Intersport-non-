package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


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
    
    private static final String fichiEr = "fichiEr.txt";// Fichier d'équipements
    private static final String fiChier = "fiChier.txt"; // Fichier de Commandes
    
    // Constructeur
    
    public Magasin(String nom_mag){
    
        this.nom_mag = nom_mag;
        
        lstEqpmt = new Equipement[3000]; // On crée une liste d'équipement en contenant 3000 différents au maximum.
        nbEqpmt = 0;
        lstCmd = new Commande[10000];   // On crée une liste de commandes passées au magasin de 10 000 au maximum.
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
        
        return nom_mag + "\n" + "Liste des équipements vendus :" + "\n" 
                       + tabEqpmt + "\n"
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
    
    static public String tableau(Object[] tab){  // Méthode renvoyant une String sous forme d'un tableau en affichant un équipement par ligne.
        
        int cpt = 0;
        for (int i=0 ; i <= tab.length-1 ; i++){ // On vérifie si la ligne du tableau est vide.
            if (tab[i] == null){
                break;
            }
            cpt++;
        }
        
        String[] strTab = new String[cpt]; // On crée notre String sous forme de tableau
        for (int i=0; i <= cpt-1 ;i++){
            strTab[i] = tab[i].toString(); // On rentre les informations des équipements proposés et des listes de commandes passées au magasin. 
        }
        
        String tabGrille = String.join("\n", strTab);
        return tabGrille;
    }
    
    /*
    Méthode permettant d'avoir la référence d'un équipement. 
    Celui-ci est composé de 2 lettres pour le nom et de 3 chiffres 
    pour son numéro. C'est une String
    */
    
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
    
    /* Méthodes ajout
       Ces méthodes permettent d'ajouter à notre liste d'équipements un nouvel 
        équipement du type de notre choix.
    */
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, float poids){
        String ref = reference("TR", cptTR);
        String test;
        for (int i=0;i<=lstEqpmt.length-1;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            test = lstEqpmt[i].getref();
            if (ref.equals(test)){
                cptTR++;
                ref = reference("TR", cptTR);
            }
        }
        
        Terrain TR;
        TR = new Terrain(ref, sport, nom, prix, nbExmpl, poids);
        lstEqpmt[cptTR+cptJO+cptPR] = TR;
        cptTR += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, float hauteur, float largeur, float poids){
        String ref = reference("TR", cptTR);
        String test;
        for (int i=0;i<=lstEqpmt.length-1;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            test = lstEqpmt[i].getref();
            if (ref.equals(test)){
                cptTR++;
                ref = reference("TR", cptTR);
            }
        }
        Terrain TR;
        TR = new Terrain(ref, sport, nom, prix, nbExmpl, hauteur, largeur, poids);
        lstEqpmt[cptTR+cptJO+cptPR] = TR;
        cptTR += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, String taille, String coloris){
        String ref = reference("JO", cptJO);
        String test;
        for (int i=0;i<=lstEqpmt.length-1;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            test = lstEqpmt[i].getref();
            if (ref.equals(test)){
                cptJO++;
                ref = reference("JO", cptJO);
            }
        }
        Joueurs JO;
        JO = new Joueurs(ref , sport, nom, prix, nbExmpl, taille, coloris);
        lstEqpmt[cptTR+cptJO+cptPR] = JO;
        cptJO += 1;
        nbEqpmt += 1;
    }
    
    public void ajout(String sport, String nom, float prix, int nbExmpl, String taille, String coloris, String niveau){
        String ref = reference("PR", cptPR);
        String test;
        for (int i=0;i<=lstEqpmt.length-1;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            test = lstEqpmt[i].getref();
            if (ref.equals(test)){
                cptPR++;
                ref = reference("PR", cptPR);
            }
        }
        
        ProtectionJoueurs PR;
        PR = new ProtectionJoueurs(ref , sport, nom, prix, nbExmpl, taille, coloris, niveau);
        lstEqpmt[cptTR+cptJO+cptPR] = PR;
        cptPR += 1;
        nbEqpmt += 1;
    }
    
    /* 
    Méthode permettant de rechercher un équipement dans la liste grâce 
    à sa référence.
    */
    
    public Equipement recherche(String refEq){
        for (int i=0;i<=lstEqpmt.length;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            String refTest = lstEqpmt[i].getref();
            if (refTest.equals(refEq)){
                return lstEqpmt[i];
            }
        }
        return null;
    }
    
    //Méthode permettant l'affichage de notre liste d'équipements
    
    public void affichage(char type, String sport){
        /*Dans cette méthode, nous n'avons pas utilisé Equipement.placeApres
        puisque tous nos tests nous ont montrés que les équipements étaient
        déjà dans le bonne ordre.*/
        Equipement[] tabSport = new Equipement[1000];
        int cpt = 0;
        for (int i=0;i<=lstEqpmt.length;i++){
            if (lstEqpmt[i] == null){   // On vérifie si la ligne est nulle.
                break;
            }
            String refTest = lstEqpmt[i].getref();
            if (refTest.charAt(0)==type){
                String sportTest = lstEqpmt[i].getsport();
                if (sportTest.equals(sport)){
                    tabSport[cpt] = lstEqpmt[i];
                    cpt++;
                }
            }
        }
        
        String grilleAffichage = tableau(tabSport);
        System.out.println("Voici le(s) résultat(s) de votre recherche :");
        System.out.println(grilleAffichage);
    }
    
    /*
      Méthode permettant de demander au client s'il veut passer la commande.
      On lui demande ensuite quel type de commande il veut passer (type de sport
      et sa quantité).
    */
    
    public LigneCommande[] choixEquip(){
        Scanner sc = new Scanner(System.in);
        LigneCommande[] tab = new LigneCommande[3000];
        int cpt = 0;
        
        while (true){
            String typeEq = "";
            while (!typeEq.equals(" ") && !typeEq.equals("T") 
                   && !typeEq.equals("J") && !typeEq.equals("P")){
                System.out.println("""
        Veuillez choisir le type d'équipement en tapant la lettre correspondante
          ( T = Terrain, J = Joueurs, P = ProtectionJoueurs ) puis sur 'Entrée'.
 Ou appuyez simplement sur 'Espace' puis 'Entrée' pour arrêter la commande.""");
                typeEq = sc.nextLine();
            }
            if (typeEq.equals(" ")){
                break;
            }
            System.out.println("Veuillez maintenant choisir le sport"
                             + " de votre choîx.");
            String sp = sc.nextLine();
            
            affichage(typeEq.charAt(0),sp);
            
            System.out.println("Veuillez maintenant choisir l'équipement"
                           + " de votre choîx en recopiant sa référence.");
            String ref = sc.nextLine();
            
            Equipement eq = recherche(ref);
            if (eq == null){
                continue;
            }
            
            int nb = 0;
            while (nb<=0){
                System.out.println("Veuillez indiquer le nombre d'exmplaire de votre choîx.");
                nb = sc.nextInt();
            }
            
            sc.nextLine();
            
            LigneCommande ligne = new LigneCommande(nb, eq);
            tab[cpt] = ligne;
            eq.setnbExmpl(eq.getnbExmpl()-nb);
            cpt++;
        }
        return tab;
    }
    
    /* 
     Méthode permettant la sauvegarde sous la forme d'un fichier texte
     des informations contenues dans notre tableau des équipements.
    */
    public void versFichierEquipements() throws IOException{
        FileWriter fich = new FileWriter(fichiEr);   // On ouvre le fichier en écriture
        for (int i=0;i<lstEqpmt.length;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            String chaine = lstEqpmt[i].versFichier();
            fich.write(chaine + System.lineSeparator());  // On écrit dans le fichier
        }
        
        fich.close();                                      //  On ferme le fichier
    }
    
    /*
      Méthode permettant de charger l'ensemble des équipements
      à  partir de son fichier texte.
    */
    
    public void depuisFichierEquipements() throws FileNotFoundException
                                                  , IOException{
        FileReader fich = new FileReader(fichiEr);     // On ouvre le fichier en lecture
        BufferedReader br = new BufferedReader(fich);
        String reference = br.readLine();                          // On lit une ligne du fichier
        while(reference != null){
            String ligne = br.readLine();
            String[] tab = ligne.split(" : ");
            String sport = tab[0];
            String nom = tab[1];
            float prix = Float.valueOf(tab[2]);
            int nbExpl = Integer.valueOf(tab[3]);
            if(reference.startsWith("JO")){
                String taille = tab[4];
                String coloris = tab[5];
                Joueurs j = new Joueurs(reference, sport, nom, prix
                                       , nbExpl, taille, coloris);
                lstEqpmt[nbEqpmt] = j;
                nbEqpmt += 1;
            }else if(reference.startsWith("PR")){
                String taille = tab[4];
                String coloris = tab[5];
                String niveau = tab[6];
                ProtectionJoueurs p = new ProtectionJoueurs(reference, sport
                            , nom, prix, nbExpl, taille, coloris, niveau);
                lstEqpmt[nbEqpmt] = p;
                nbEqpmt += 1;
            }else{
                float hauteur = Float.valueOf(tab[4]);
                float largeur = Float.valueOf(tab[5]);
                float poids = Float.valueOf(tab[6]);
                Terrain t = new Terrain(reference, sport, nom, prix, nbExpl, hauteur, largeur, poids);
                lstEqpmt[nbEqpmt] = t;
                nbEqpmt += 1;
            }
            reference = br.readLine();  // On lit la ligne
        }
        fich.close();  // On ferme le fichier
    }
    
    /* 
     Méthode permettant la sauvegarde sous la forme d'un fichier texte
     des informations contenues dans notre tableau de commandes.
    */
    public void versFichierCommandes() throws IOException{
        FileWriter fich = new FileWriter(fiChier);  // On ouvre le fichier en écriture
        for (int i=0;i<lstCmd.length;i++){
            if (lstCmd[i] == null){
                break;
            }
            String lignCom = lstCmd[i].versFichier();
            LigneCommande[] tabLignes = lstCmd[i].getlignes();
            String chaine = "";
            for (int j=0;j<tabLignes.length;j++){
                chaine += tabLignes[j].versFichier() + System.lineSeparator();
            }
            fich.write(lignCom + System.lineSeparator() + chaine); // On écrit dans le fichier
        }
        
        fich.close();                                       // On ferme le fichier
    }
    
    /*
      Méthode permettant de charger l'ensemble de commandes
      à  partir de son fichier texte.
    */
    public void depuisFichierCommandes() throws FileNotFoundException, IOException{
        FileReader fich = new FileReader(fiChier);      // On ouvre le fichier en lecture
        BufferedReader br = new BufferedReader(fich);
        String numero = br.readLine();                     // On lit une ligne du fichier
        while(numero != null){
            String donnees = br.readLine();
            String[] info = donnees.split(" : ");
            String email = info[0];
            LocalDate emission = dateEcrite(info[1]);
            LocalDate livraison = dateEcrite(info[2]);
            float total = Float.valueOf(info[3]);
            String nombreLignes = br.readLine();
            int nbL = Integer.valueOf(nombreLignes);
            LigneCommande[] lignes = new LigneCommande[nbL];
            for (int i=0;i<nbL;i++){             
                String ligne = br.readLine();
                String[] bon = ligne.split(" : ");
                String ref = bon[0];
                int nbExpl = Integer.valueOf(bon[1]);
                Equipement eq = recherche(ref);
                LigneCommande lc = new LigneCommande(nbExpl, eq);
                lignes[i] = lc;
            }
            Commande com = new Commande(numero, email, emission, livraison, lignes);
            lstCmd[nbCmd] = com;
            nbCmd++;
            numero = br.readLine();
        }
        
        fich.close();
    }
    
    // Méthode permettant d'afficher la date (année-mois-jour)de la date de livraison.
    
    public LocalDate dateEcrite(String date){
        String[] tab = date.split("-");
        int annee = Integer.valueOf(tab[0]);
        int mois = Integer.valueOf(tab[1]);
        int jour = Integer.valueOf(tab[2]);
        return LocalDate.of(annee, mois, jour);
    }
    
    // Méthode permettant de 
    
    public void replacement(){
        
        boolean k = true;
        
        for (int i=0;i<lstEqpmt.length-1;i++){
            if (k == false){
                break;
            }
            for (int j=0; j<=lstEqpmt.length-1;j++){ 
                if (lstEqpmt[j+1] == null){
                    k = false;
                    break;
                }
                if (lstEqpmt[j].placeApres(lstEqpmt[j+1])){

                    Equipement t = lstEqpmt[j];
                    lstEqpmt[j] = lstEqpmt[j+1];
                    lstEqpmt[j+1] = t;       
                }
            }
        }
    }
    
}
