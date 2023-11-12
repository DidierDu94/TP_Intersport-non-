package tp_decathlon;

// @author Calmet Pierre && Bertin Pierre-Aloïs

public class TP_Decathlon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Terrain t;
        t = new Terrain("TR128", "Escalade", "Corde", 114.99f, 78, 70, 0.01f, 0.400f);
        //System.out.println(t);
        Joueurs j;
        j = new Joueurs("JO032", "Natation", "Bonnet", 10, 209, "XL", "bleu");
        //System.out.println(j);
        
        
        Equipement[] lignes = {t,j};
        
        String[] strLignes = new String[lignes.length];
        for (int i=0;i<=lignes.length-1;i++){
            strLignes[i] = lignes[i].toString();
        }
        String tabLignes = String.join("\n", strLignes);
        
        System.out.println(tabLignes);
        
        
    }
    
    
}
