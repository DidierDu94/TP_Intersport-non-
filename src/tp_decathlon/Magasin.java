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
    private Equipement[] lstEqpmt; // Ensemble des équipements vendus au magasin
    private int nbCmd;          // Nombre de commandes passées depuis le magasin
    private Commande[] lstCmd;      // Ensemble des commandés passées au magasin
    
            // Compteur spécifique pour la référence des équipements de Terrain
    private int cptTR;
            // Compteur spécifique pour la référence des équipements de Joueurs
    private int cptJO;
   // Compteur spécifique pour la référence des équipements de ProtectionJoueurs
    private int cptPR;
    
    /*Fichier où sont stockés toutes les informations concernant les équipements
    vendus par le magasin.*/
    private static final String FichierEquipements = "FichierEquipements.txt";
    /*Fichier où sont stockés toutes les informations concernant les commandes
    passées dans le magasin.*/
    private static final String FichierCommandes = "FichierCommandes.txt";
    
    // Constructeur
    
    public Magasin(String nom_mag){
    
        this.nom_mag = nom_mag;
        
        /*
        Nous avons choisi pour la taille de la liste d'équipememnts une valeur
        de 3000, puisqu'il s'agit du maximum possible pour les références.
        Elles vont de 000 à 999 ce qui fait 1000 (*3 = 3000).
        */
        lstEqpmt = new Equipement[3000];
        nbEqpmt = 0;
        /*
        Nous avons choisi pour la taille de la liste de commandes une valeur de
        10000, puisque c'est le maximum possible pour les références.
        Elles vont de 0000 à 9999 ce qui fait 10000.
        */
        lstCmd = new Commande[10000];
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
    
    /*
    Méthode renvoyant une chaîne de caractères sous forme d'un tableau
    en affichant un élément par ligne.
    */
    static public String tableau(Object[] tab){
        int cpt = 0;
        for (int i=0 ; i <= tab.length-1 ; i++){
            if (tab[i] == null){
                break;
            }
            cpt++;
        }
        String[] strTab = new String[cpt];
        for (int i=0; i <= cpt-1 ;i++){
            strTab[i] = tab[i].toString();
        }
        String tabGrille = String.join("\n", strTab);
        return tabGrille;
    }
    
    // Méthode permettant de créer la référence des équipements.
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
    
    
    // Méthodes ajout() pourn les équipements
    
    /*
    Ces méthodes permettent d'ajouter des équipements au magasin.
    Elles sont définis par surcharge et permettent de créer les 3 (ou 4)
    instances possibles.
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
        replacement();          // On met les éléments dans l'ordre.
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
        replacement();                  // On met les éléments dans l'ordre.
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
        replacement();              // On met les éléments dans l'ordre.
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
        replacement();                  // On met les éléments dans l'ordre.
    }
    
    // Méthode retournant un équipement d'après sa référence.
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
    
    /*
    Cette méthode permet d'afficher tous les équipements correspondant au type
    et au sport souhaité.
    Elle utilise la méthode tableau() pour la mise en forme.
    */
    public void affichage(char type, String sport){
        Equipement[] tabSport = new Equipement[1000];
        int cpt = 0;
        for (int i=0;i<=lstEqpmt.length;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            String refTest = lstEqpmt[i].getref();
            if (refTest.charAt(0) == type){
                String sportTest = lstEqpmt[i].getsport();
                if (sportTest.equalsIgnoreCase(sport)){
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
    Cette méthode permet à un acheteur de choisir les équipements qu'il
    souhaite commander.
    
    Au début, on crée le scanner et le tableau qui contiendra
    les lignes de commande.
    */
    public LigneCommande[] choixEquip(){
        Scanner sc = new Scanner(System.in);
        LigneCommande[] tab = new LigneCommande[3000];
        int cpt = 0;
        
        /*
        On rentre ensuite dans une grande boucle où l'acheteur peut choisir un à
        un ses équipements.
        Il tape tout d'abord la lettre correspondant au type d'équipement.
        Il peut aussi finir sa commande en tapant 'Espace'.
        */
        while (true){
            String typeEq = "";
            while (!typeEq.equalsIgnoreCase(" ") 
                    && !typeEq.equalsIgnoreCase("T") 
                    && !typeEq.equalsIgnoreCase("J") 
                    && !typeEq.equalsIgnoreCase("P")){
                System.out.println("""
Veuillez choisir le type d'équipement en tapant la lettre correspondante
( T = Terrain, J = Joueurs, P = ProtectionJoueurs ) puis sur 'Entrée'.
Ou appuyez simplement sur 'Espace' puis 'Entrée' pour arrêter la commande.""");
                typeEq = sc.nextLine();
            }
            if (typeEq.equalsIgnoreCase(" ")){
                break;
            }
            
            /*
            Ensuite il indique le sport.
            Ici, il n'y a pas de boucle donc si le nom du sport est mal
            orthographié, l'équipement ne sera pas trouvé dans la liste.
            */
            System.out.println("Veuillez maintenant choisir le sport"
                    + " de votre choîx.");
            String sp = sc.nextLine();
            
            /*
            On lui affiche ensuite les équipements disponible en magasin et
            correspondant à sa recherche.
            */
            affichage(typeEq.toUpperCase().charAt(0),sp);
            
            /*
            Parmi la liste qu'il peut voir, il choisit son équipement en
            rentrant sa référence. Ici aussi la syntaxe est importante.
            Il doit faire attention parce qu'il peut auusi sélectionner un autre
            équipement qui n'apparait pas dasn le tableau en écrivant sa
            référence.
            */
            System.out.println("Veuillez maintenant choisir l'équipement"
                    + " de votre choîx en recopiant sa référence.");
            String ref = sc.nextLine();
            
            // Si la référence ne correspond à rien, il recommence du début.
            Equipement eq = recherche(ref);
            if (eq == null){
                continue;
            }
            
            /*
            L'utilisateur choisit enfin le nombre d'exemplaire qu'il souhaite.
            En ce mettant dans une boucle avec une petite condition, on s'assure
            que la valeur rentré n'est pas négative (cela n'aurait pas de sens).
            */
            int nb = 0;
            while (nb<=0){
                System.out.println("Veuillez indiquer le nombre d'exmplaire"
                        + " de votre choîx.");
                nb = sc.nextInt();
            }
            
            sc.nextLine();
            
            /*
            On crée donc l'instance LigneCommande, on la met dans le tableau et
            on recommence.
            */
            LigneCommande ligne = new LigneCommande(nb, eq);
            tab[cpt] = ligne;
            cpt++;
        }
        return tab;
    }
    
    /*
    Cette méthode permet de sauvegarder les équipements disponibles en magasin
    et leurs informations dans un fichier texte (.txt).
    */
    public void versFichierEquipements() throws IOException{
                                            // ouvrir le fichier en écriture
        FileWriter fich = new FileWriter(FichierEquipements);
        for (int i=0;i<lstEqpmt.length;i++){
            if (lstEqpmt[i] == null){
                break;
            }
            String chaine = lstEqpmt[i].versFichier();
                                                    // écrire dans le fichier
            fich.write(chaine + System.lineSeparator());
        }
        fich.close();                                     // fermer le fichier
    }
    
    /*
    Méthode permettant d'importer les informations d'un magasin depuis un
    fichier texte (.txt).
    */
    public void depuisFichierEquipements() throws FileNotFoundException,
            IOException{
                                                // ouvrir le fichier en lecture
        FileReader fich = new FileReader(FichierEquipements);
        BufferedReader br = new BufferedReader(fich);
        String reference = br.readLine();          // lire une ligne du fichier
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
                Joueurs j = new Joueurs(reference, sport, nom, prix,
                        nbExpl, taille, coloris);
                lstEqpmt[nbEqpmt] = j;
                nbEqpmt += 1;
            }else if(reference.startsWith("PR")){
                String taille = tab[4];
                String coloris = tab[5];
                String niveau = tab[6];
                ProtectionJoueurs p = new ProtectionJoueurs(reference, sport,
                        nom, prix, nbExpl, taille, coloris, niveau);
                lstEqpmt[nbEqpmt] = p;
                nbEqpmt += 1;
            }else{
                float hauteur = Float.valueOf(tab[4]);
                float largeur = Float.valueOf(tab[5]);
                float poids = Float.valueOf(tab[6]);
                Terrain t = new Terrain(reference, sport, nom, prix,
                        nbExpl, hauteur, largeur, poids);
                lstEqpmt[nbEqpmt] = t;
                nbEqpmt += 1;
            }
            reference = br.readLine();
        }
        replacement();              // On met les éléments dans l'ordre.
        fich.close();                                     // fermer le fichier
    }
    
    /*
    Cette méthode permet de sauvegarder les commandes passées dans le magasin
    et leurs informations dans un fichier texte (.txt).
    */
    public void versFichierCommandes() throws IOException{
                                            // ouvrir le fichier en écriture
        FileWriter fich = new FileWriter(FichierCommandes);
        for (int i=0;i<lstCmd.length;i++){
            if (lstCmd[i] == null){
                break;
            }
            String lignCom = lstCmd[i].versFichier();
            LigneCommande[] tabLignes = lstCmd[i].getlignes();
            String chaine = "";
            for (int j=0;j<tabLignes.length;j++){
                if(tabLignes[j] == null){
                    break;
                }
                chaine += tabLignes[j].versFichier() + System.lineSeparator();
            }
                                                       // écire dans le fichier
            fich.write(lignCom + System.lineSeparator() + chaine);
        }
        fich.close();                                  // fermer le fichier
    }
    
    /*
    Méthode permettant d'importer les informations d'un magasin depuis un
    fichier texte (.txt).
    */
    public void depuisFichierCommandes() throws FileNotFoundException,
            IOException{
                                                // ouvrir le fichier en lecture
        FileReader fich = new FileReader(FichierCommandes);
        BufferedReader br = new BufferedReader(fich);
        String numero = br.readLine();             // lire une ligne du fichier
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
            Commande com = new Commande(numero, email, emission, livraison,
                    lignes);
            lstCmd[nbCmd] = com;
            nbCmd++;
            numero = br.readLine();
        }
        classement();                   // On met les éléments dans l'ordre.
        fich.close();                                   // fermer le fichier
    }
    
    // Méthode transformant une chaîne en date.
    public LocalDate dateEcrite(String date){
        String[] tab = date.split("-");
        int annee = Integer.valueOf(tab[0]);
        int mois = Integer.valueOf(tab[1]);
        int jour = Integer.valueOf(tab[2]);
        return LocalDate.of(annee, mois, jour);
    }
    
    // Méthode permettant de mettre les équipements dans l'ordre dans le tableau.
    public void replacement(){
        for (int i=0;i<lstEqpmt.length-1;i++){
            if (lstEqpmt[i+1] == null){
                break;
            }
            for (int j=0; j<=lstEqpmt.length-1;j++){ 
                if (lstEqpmt[j+1] == null){
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
    
    /*
    Cette méthode permet à un acheteur de faire sa commmande.
    Il écrit son adresse électronique puis choisit ses équipements grâce à la
    méthode choixEquip().
    */
    public void ajout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez nous indiquer votre adresse courriel :");
        String email = sc.nextLine().toLowerCase();
        System.out.println("Vous allez maintenant choisir les équipements que"
                + " vous voulez acheter.");
        LigneCommande[] materiel = choixEquip();
        tri(materiel);          // On met les éléments dans l'ordre.
        float total = 0f;
        long delai = 0L;
        for(int i=0;i<materiel.length;i++){
            if(materiel[i]==null){
                break;
            }
            total += materiel[i].getprixUni();
            int nb = materiel[i].getnbExempl();
            long del = recherche(materiel[i].getref()).calculDelai(nb);
            if(del>delai){
                delai = del;
            }
            recherche(materiel[i].getref()).majDispo(nb*(-1));
        }
        LocalDate emission = LocalDate.now();
        LocalDate livraison = emission.plusDays(delai);
        String test;
        String cpt = reference(nbCmd);
        String num = "";
        for(int i=0;i<lstCmd.length;i++){
            num = "" + emission.getYear() + cpt;
            if (lstCmd[i] == null){
                break;
            }
            test = lstCmd[i].getnumero();
            if (num.equals(test)){
                nbCmd++;
                cpt = reference(nbCmd);
            }
        }
        
        /*
        Après avoir récupéré toutes les informations de la commande, on la crée
        et on l'ajoute à la liste.
        On donne ensuite un petit récapitulatif de la commande à l'acheteur.
        */
        Commande com = new Commande(num, email, emission, livraison, materiel);
        lstCmd[nbCmd] = com;
        System.out.println("Votre commande s'élève à un montant de "
                + com.gettotal() + " €.");
        System.out.println("Elle vous sera livrée le " + com.getlivraison()
                + ".");
        System.out.println("Votre numéro de commande est le : "
                + com.getnumero());
        nbCmd++;
        classement();                   // On met les éléments dans l'ordre.
    }
    
    // Méthode permettant de créer la référence des commandes.
    public String reference(int cp){
        String cpt;
        if(nbCmd<10){
                cpt = "000" + nbCmd;
            }else if(nbCmd<100){
                cpt = "00" + nbCmd;
            }else if(nbCmd<1000){
                cpt = "0" + nbCmd;
            }else{
                cpt = "" + nbCmd;
            }
        return cpt;
    }
    
    // Méthode qui affiche les commandes passées par une collectivité donnée.
    public void affichage(String courriel){
        System.out.println("Voici les commandes effectuées par "+courriel+" :");
        for(int i=0;i<lstCmd.length;i++){
            if(lstCmd[i]==null){
                break;
            }
            String adresse = lstCmd[i].getemail();
            if(courriel.equalsIgnoreCase(adresse)){
                System.out.println(lstCmd[i]);
            }
        }
    }
    
    // Méthode affichant les commande devant être livrée avant une date précise.
    public void affichage(LocalDate date){
        System.out.println("Voici les commandes devant être livrées après : "
                + date);
        for(int i=0;i<lstCmd.length;i++){
            if(lstCmd[i]==null){
                break;
            }
            LocalDate test = lstCmd[i].getlivraison();
            if(test.isAfter(date)){
                System.out.println(lstCmd[i]);
            }
        }
    }
    
    // Méthode permettant de mettre les commandes dans l'ordre dans le tableau.
    public void classement(){
        for (int i=0;i<lstCmd.length-1;i++){
            if (lstCmd[i+1] == null){
                break;
            }
            for (int j=0; j<=lstCmd.length-1;j++){ 
                if (lstCmd[j+1] == null){
                    break;
                }
                if (lstCmd[j].placeApres(lstCmd[j+1])){

                    Commande t = lstCmd[j];
                    lstCmd[j] = lstCmd[j+1];
                    lstCmd[j+1] = t;
                }
            }
        }
    }
    
    // Méthode permettant de mettre les lignes dans l'ordre dans le tableau.
    public void tri(LigneCommande[] element){
        for (int i=0;i<element.length-1;i++){
            if (element[i+1] == null){
                break;
            }
            for (int j=0; j<=element.length-1;j++){ 
                if (element[j+1] == null){
                    break;
                }
                if (element[j].placeApres(element[j+1])){

                    LigneCommande t = element[j];
                    element[j] = element[j+1];
                    element[j+1] = t;
                }
            }
        }
    }
}
