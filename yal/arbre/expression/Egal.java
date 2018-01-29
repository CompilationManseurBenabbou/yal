package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
        type="bool";
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void verifier() {
        if (!(gauche.getType() == droite.getType()))
            throw new AnalyseSemantiqueException("Les opperandes ne sont pas du meme type");
    }

    @Override
    public String toMIPS() {

    StringBuilder sb = new StringBuilder();
    sb.append(gauche.toMIPS()+"\n"+// Evaluation de l'op gauche
            "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
            "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
            droite.toMIPS()+"\n"+//Evaluation de l'op Droite
            "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
            "lw $t8,0($sp)"+"\n"+ //Chargement de l'op gauche dans t8
            "beq $v0,$t8,suite"+incr+"\n"+
            "li $v0,0\n" +
            "j continuer"+incr+"\n"+
            "suite"+incr+": li $v0,1\n" +
            "continuer"+incr+" :\n");// Realisation de l'addition;);
    incr++;
        return sb.toString();

    }
}
