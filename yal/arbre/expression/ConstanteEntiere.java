package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
        type="entier"; //Assignation du type entier pour toutes les constants booleans
    }

    @Override
    //Recuperation de la veleur de du String cste
    public int getValue() {
        return Integer.parseInt(cste);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "li $v0,"+cste;
    }
}
