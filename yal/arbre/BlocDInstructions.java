package yal.arbre;

import yal.arbre.expression.Expression;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    protected ArrayList<ArbreAbstrait> expr;


    @Override
    public int getValue() {
        return 0;
    }

    public BlocDInstructions(int n) {
        super(n) ;
        expr=new ArrayList<>();

    }

    @Override
    public void verifier() {
        for (ArbreAbstrait a:expr ) {
            a.verifier();
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder sb=new StringBuilder();
        sb.append(".text\n" +
                "main :\n\n");
        for (ArbreAbstrait a:expr ) {
            sb.append(a.toMIPS());
        }
        sb.append("\n end :\n" +
                "         move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de plic0\n" +
                "         li $v0, 10               # retour au système\n" +
                "         syscall\n");
        return sb.toString();
    }

    public void ajouter(ArbreAbstrait a) {
        expr.add(a) ;
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

}
