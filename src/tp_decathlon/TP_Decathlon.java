package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs
// TDTP3: Vente d'équipements sportifs

import java.io.IOException;

// Main class

public class TP_Decathlon {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*Terrain t;
        t = new Terrain("TR128", "Escalade", "Corde", 114.99f, 78, 70, 0.01f, 0.400f);
        //System.out.println(t);
        Joueurs j;
        j = new Joueurs("JO032", "Natation", "Bonnet", 10, 209, "XL", "bleu");
        //System.out.println(j);
        ProtectionJoueurs p;
        p = new ProtectionJoueurs("PR054", "Rugby", "Protège dents", 7.99f, 1808, "XXL", "noir", "avancé");
        
        
        Equipement[] lignes = {t,j,p};
        String tabLignes = Magasin.tableau(lignes);
        System.out.println(tabLignes);*/
        
        /*String str = "TR111";
        String sts = "TR124";
        //int test = str;
        //System.out.println(str.compareTo(sts));
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(0)==sts.charAt(0));*/
        
        //String t[] = new String[3];
        //System.out.println(t[2]);
        
        Magasin M = new Magasin("Sport2000");
        M.ajout("Escalade", "Corde", 114.99f, 78, 70, 0.01f, 0.400f);
        M.ajout("Natation", "Bonnet", 10, 209, "XL", "bleu");
        M.ajout("Rugby", "Protège dents", 7.99f, 1808, "XXL", "noir", "avancé");
        M.ajout("Escalade", "Chaussons", 58.99f, 14, "XS", "orange");
        M.ajout("Natation", "Ligne d'eau", 395, 50, 25, 0.1f, 60);
        M.ajout("Rugby", "Maillot", 4, 2893, "XXS", "bleu");
        M.ajout("Natation", "Chariot enrouleur", 1751.22f, 23,1.6f, 3, 85);
        
        M.Replacement();
        
                    
       
                    // créer une vairable pour break;
                    
        //System.out.println(M.tableau(M.choixEquip()));
        
        M.versFichierEquipements();
        
    }
    
    
    
}
