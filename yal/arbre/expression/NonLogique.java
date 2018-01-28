package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
        type="bool";
    }

    @Override
    public String operateur() {
        return " non " ;
    }

    @Override
    public void verifier() {
        if (!(expression.getType()=="bool")) throw new AnalyseSemantiqueException("Le type de l'opperande n'est pas binaire");
    }

    @Override
    public String toMIPS() {
        if (expression.equals("vrai")) {
            return "0";
        }
        return "1";
    }
}
