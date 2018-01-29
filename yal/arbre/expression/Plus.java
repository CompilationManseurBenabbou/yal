package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {

        super(gauche, droite);
        type="entier";
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

    @Override
    public int getValue() {
        return gauche.getValue()+gauche.getValue();
    }

    @Override
    public void verifier() {

        if (!(gauche.getType() == droite.getType()&&gauche.getType()=="entier"))
            throw new AnalyseSemantiqueException("Les opp ne sont pas du meme type");
    }
    @Override
    public String toMIPS() {
        return gauche.toMIPS()+"\n"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
                "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
                droite.toMIPS()+"\n"+//Evaluation de l'op Droite
                "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+"\n"+ //Chargement de l'op droite dans t8
                "add $v0,$t8,$v0\n";// Realisation de l'addition
    }
}
