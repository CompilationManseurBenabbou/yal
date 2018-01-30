package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {

        super(texte, n) ;
        //Assignation du type bool pour toutes les constants booleans
        type="bool";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void verifier() {
    }

    @Override
    public String toMIPS() {
        if (cste.equals("vrai")){
            return "li $v0,1"; //Chargement de la valeur 1 dans $v0 si cste est egale à vrai
        }
        return "li $v0,0";//sinon chargement de la valeur 1 dans $v0

    }
}
