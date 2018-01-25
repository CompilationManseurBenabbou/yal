package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        if (cste.equals(true)){
            return "li $v0,1";
        }
        return "li $v0,0";

    }
}
