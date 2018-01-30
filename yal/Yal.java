package yal ;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Yal {
    
    public Yal(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            //System.err.println("expression stockée dans l'arbre : " + arbre);

            // à écrire pour yal0
             arbre.verifier() ;
             //System.out.println(arbre.toMIPS());
            tofichier(arbre.toMIPS(),fichier);
             System.out.println("Compilation OK");
        }
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Yal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void tofichier(String expression,String nomfichier){
       nomfichier=nomfichier.substring(0,nomfichier.length()-4)+".mips";
        try {
            FileWriter fw = new FileWriter(nomfichier);
            BufferedWriter output = new BufferedWriter(fw);
            output.write(expression);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar yal.jar <fichierSource.yal>") ;
            System.exit(1) ;
        }

        new Yal(args[0]) ;
    }
    
}
