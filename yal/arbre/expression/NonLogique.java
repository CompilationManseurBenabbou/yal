package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        if (expression.equals(true)) {
            return "li $0,0";
        }
        return "li $0,1";
    }
}
