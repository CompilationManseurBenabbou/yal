package yal.arbre.expression;

import yal.exceptions.AnalyseExecutionException;
import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {

        super(gauche, droite);
        type="entier";
    }

    @Override
    public int getValue() {
     return gauche.getValue()/droite.getValue();
    }


    @Override
    public String operateur() {
        return " / ";
    }

    @Override
    public void verifier() {
        if (!(gauche.getType() == droite.getType()&&gauche.getType()=="entier"))
            throw new AnalyseSemantiqueException("Les opperandes ne sont pas du meme type");
        if (droite.getValue()==0){
            throw new AnalyseExecutionException("La Valeur du diviseur est nulle ");
        }

    }

    @Override
    public String toMIPS() {
        return droite.toMIPS()+"\n"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
                "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
                gauche.toMIPS()+"\n"+//Evaluation de l'op Droite
                "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+"\n"+ //Chargement de l'op gauche dans t8
                "div $v0,$t8\n" +
                "mflo $v0\n";// Realisation de l'addition;
    }
}
