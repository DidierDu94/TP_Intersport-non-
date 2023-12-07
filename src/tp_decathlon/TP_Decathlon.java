package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

// Main class

public class TP_Decathlon {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*
        
        Ces lignes sont des équipements pour créer un magasin qui n'est pas
        vide.
        
        M.ajout("Escalade", "Corde", 114.99f, 78, 70, 0.01f, 0.400f);
        M.ajout("Natation", "Bonnet", 10, 209, "XL", "bleu");
        M.ajout("Rugby", "Protège dents", 7.99f, 1808, "XXL", "noir", "avancé");
        M.ajout("Escalade", "Chaussons", 58.99f, 14, "XS", "orange");
        M.ajout("Natation", "Ligne d'eau", 395, 50, 25, 0.1f, 60);
        M.ajout("Rugby", "Maillot", 4, 2893, "XXS", "bleu");
        M.ajout("Natation", "Chariot enrouleur", 1751.22f, 23,1.6f, 3, 85);
        */
        
        /*
        Dans ce début de programme, nous avons créé un scanner et une instance
        de magasin. Puis nous avons ajouté des équipements et commandes grâce
        aux méthodes depuisFichier* 
        */
        Scanner sc = new Scanner(System.in);
        Magasin M = new Magasin("Sport2000");
        M.depuisFichierEquipements();
        M.depuisFichierCommandes();
        /*
        A la suite de ce programme, nous invitons l'utilisateur du programme
        à indiquer sa fonction, dans une boucle pour ne pas avoir n'importe
        quoi. On permetra à l'utilisateur dans la quasi-totalité du programme
        d'utiliser des majuscules ou minuscules sans conséquences.
        */
        String perso = "";
            while (!perso.equals(" ") && !perso.equals("A")
                    && !perso.equals("F") && !perso.equals("E")){
                System.out.print("""
                    Qui êtes-vous ?
                    Un acheteur ? Tapez 'A' puis 'Entrée'.
                    Un fournisseur ? Tapez 'F' puis 'Entrée'.
                    Un employé du magasin ? Tapez 'E' puis 'Entrée'.""");
                System.out.println("Si vous ne correspondez pas à ces"
                        + " descriptions, tapez 'Espace' puis 'Entrée'.");
                perso = sc.nextLine();
                perso = perso.toUpperCase();
            }
            switch(perso){
                /*
                Dans la première situation, l'utilisateur est une personne sans
                liens avec le magasin. Ce cas permet également d'initialiser
                les fichier FichierCommandes et FichierEquipements.
                (Attention il faut néanmoins modifier légèrement le programme
                pour qu'il n'essaie pas de lire un fichier inexistant.)
                */
                case " ":
                    break;
                
                /*
                Dans cette situation, l'utilisateur est un acheteur et effectue
                donc une commande. On utilise pour cela la méthode ajout() pour
                les commandes.
                */
                case "A":
                    System.out.println("Vous êtes donc un acheteur.");
                    M.ajout();
                    break;
                
                /*
                Dans cette autre situation, l'utilisateur est un fournisseur,
                il va donc donner les informations correspondant à un équipement
                en faisant très attention à la syntaxe. On utilise pour cela une
                chaîne - que l'on va séparer avec .split() - et les méthodes
                ajout() pour les équipememnts.
                */
                case "F":
                    System.out.println("Vous êtes donc un de nos fournisseurs.");
                    System.out.println("Veuillez nous indiquer les informations concernant votre livraison séparées par ' : '.");
                    String info = sc.nextLine();
                    String[] tab = info.split(" : ");
                    String sport = tab[0];
                    String nom = tab[1];
                    float prix = Float.valueOf(tab[2]);
                    int nbExpl = Integer.valueOf(tab[3]);
                    switch(tab.length){
                        case 5:
                            float poids = Float.valueOf(tab[4]);
                            M.ajout(sport, nom, prix, nbExpl, poids);
                            break;
                        case 6:
                            String taille = tab[4];
                            String coloris = tab[5];
                            M.ajout(sport, nom, prix, nbExpl, taille, coloris);
                            break;
                        case 7:
                            if(tab[4].getClass().getSimpleName().equalsIgnoreCase("float")){
                                float hauteur = Float.valueOf(tab[4]);
                                float largeur = Float.valueOf(tab[5]);
                                poids = Float.valueOf(tab[6]);
                                M.ajout(sport, nom, prix, nbExpl, hauteur, largeur, poids);
                                break;
                            }else{
                                taille = tab[4];
                                coloris = tab[5];
                                String niveau = tab[6];
                                M.ajout(sport, nom, prix, nbExpl, taille, coloris, niveau);
                                break;
                            }
                    }
                    break;
                
                /*
                Enfin, dans ce dernier cas, l'utilisateur est un employé du
                magasin. On va donc s'intéresser aux commandes et utiliser les
                méthodes affichage() pour ces-dernières.
                */
                case "E":
                    System.out.println("Vous êtes donc employé chez nous.");
                    String but = "";
                    while (!but.equalsIgnoreCase("C")
                            && !but.equalsIgnoreCase("D")){
                        System.out.print("""
    Que souhaitez-vous faire ?
    Voir la liste des commandes selon la collectivité ? Tapez 'C' puis 'Entrée'.
    Voir la liste des commandes à livrer après une date particulière ? """);
                        System.out.println("Tapez 'D' puis 'Entrée'.");
                        but = sc.nextLine();
                    }
                    if(but.equalsIgnoreCase("C")){
                        System.out.println("Veuillez indiquer le courriel"
                                + " de la collectivité recherchée.");
                        String adresse = sc.nextLine();
                        M.affichage(adresse);
                        break;
                    }else{
                        System.out.println("Veuillez indiquer la date voulue"
                                + " séparé par '-' (exemple : 1963-11-22).");
                        String[] date = sc.nextLine().split("-");
                        LocalDate limit = LocalDate.of(
                                Integer.valueOf(date[0]),
                                Integer.valueOf(date[1]),
                                Integer.valueOf(date[2]));
                        M.affichage(limit);
                        break;
                    }
            }
            /*
            Pour finir, on enregistre les commandes et équipements du magasin
            dans des fichiers texte (.txt).
            */
            M.versFichierEquipements();
            M.versFichierCommandes();
        
    }
    
}
