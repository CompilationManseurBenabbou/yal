package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {

        super(gauche, droite);
        type="bool";
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }

    @Override
    public void verifier() {
        if (!(gauche.getType() == droite.getType()&&gauche.getType()=="bool"))
            throw new AnalyseSemantiqueException("Les opperandes ne sont pas du meme type");
    }

    @Override
    public String toMIPS() {
        return  gauche.toMIPS()+"\n"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+"\n"+//empilation de l'op gauche
                "add $sp,$sp,-4"+"\n"+//Deplacement du curseur d'une case
                droite.toMIPS()+"\n"+//Evaluation de l'op Droite
                "add $sp,$sp,4"+"\n"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+"\n"+ //Chargement de l'op gauche dans t8
                "and $v0,$t8,$v0\n";// Realisation de l'addition
    }
}
