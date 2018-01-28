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

        for (ArbreAbstrait a:expr ) {
            sb.append(a.toMIPS());
        }
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
