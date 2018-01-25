package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "li $v0,0"+// Evaluation de l'op gauche
                "sw $v0,0($sp)"+//empilation de l'op gauche
                "add $sp,$sp,-4"+//Deplacement du curseur d'une case
                "li $v0,"+expression+//Evaluation de l'op Droite
                "add $sp,$sp,4"+//Deplacement du curseur vers l'op gauche
                "lw $t8,0($sp)"+ //Chargement de l'op gauche dans t8
                "sub $v0,$t8,$v0";// Realisation de l'addition;
    }
}
