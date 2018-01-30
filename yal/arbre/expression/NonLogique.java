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
        expression.verifier();
        if (!(expression.getType()=="bool")) throw new AnalyseSemantiqueException("Le type de l'opperande n'est pas binaire");
    }

    @Override
    public String toMIPS() {

        StringBuilder sb=new StringBuilder();
        sb.append(
                expression.toMIPS()+"\n"+//Evaluation de l'op
                        "beq $v0,0,res"+incr+"\n" +//si l'op est egal à 0
                        "li,$v0,0\n"+//Sinon = 1
                        "j continuer"+incr+"\n"+//Jump
                        "res"+incr+": li,$v0,1\n"+// Alors = 1
                        "continuer"+incr+" :\n");//Fin
        incr++;
        return sb.toString();
    }
}
