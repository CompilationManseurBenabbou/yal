package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
        type="entier";
    }

    @Override
    public String operateur() {
        return "- " ;
    }

    @Override
    public int getValue() {
        return -expression.getValue();
    }

    @Override
    public void verifier() {
        expression.verifier();
        if (!(expression.getType()=="entier")) throw  new AnalyseSemantiqueException("Le type de l'opperande n'est pas un entier");
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        //Realisation du moins unaire en soustrayant l'op de 0
        sb.append("li $v0,0"+"\n"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
                "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
                expression.toMIPS()+"\n"+//Evaluation de l'op Droite
                "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+"\n"+ //Chargement de l'op gauche dans t8
                "sub $v0,$t8,$v0\n");// Realisation de soustraction;
        return sb.toString();
    }
}
