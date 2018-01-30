package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
        type="bool";//Assignation du type bool pour la valeur de retour de Different
    }

    @Override
    public String operateur() {
        return " != ";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void verifier() {
        gauche.verifier();
        droite.verifier();
        if (!(gauche.getType() == droite.getType()))
        throw new AnalyseSemantiqueException("Les opperandes ne sont pas du meme type\n"+
                                                "L'opperande gauche est de type : "+gauche.getType()+"\n"+
                                                    "L'opperande droite est de type : "+droite.getType());
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append(gauche.toMIPS()+"\n"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
                "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
                droite.toMIPS()+"\n"+//Evaluation de l'op Droite
                "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+ "\n"+//Chargement de l'op gauche dans t8
                "bne $v0,$t8,si"+incr+"\n"+//si l'op gauche est differente de l'op droite
                "li $v0,0\n" +//Sinon
                "j fin"+incr+"\n" +//Jump
                "si"+incr+":li $v0,1\n" +//Alors
                "fin"+incr+":");//Fin
        incr++;
        return sb.toString();
    }
}
