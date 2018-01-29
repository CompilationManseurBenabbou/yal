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
    public int getValue() {
        return 0;
    }

    @Override
    public void verifier() {
        if (!(expression.getType()=="bool")) throw new AnalyseSemantiqueException("Le type de l'opperande n'est pas binaire");
    }

    @Override
    public String toMIPS() {

        StringBuilder sb=new StringBuilder();
        sb.append(
                expression.toMIPS()+"\n"+
                        "beq $v0,0,res"+incr+"\n" +
                        "li,$v0,0\n"+
                        "j continuer"+incr+"\n"+
                        "res"+incr+": li,$v0,1\n"+
                        "continuer"+incr+" :\n");

        return sb.toString();
    }
}
