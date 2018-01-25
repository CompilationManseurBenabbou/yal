package yal.analyse;

import yal.arbre.expression.Expression;

public class Type {
    protected int ENTIER =1;
    protected int FLOAT =2;
    protected int BOOLEAN =3;
    protected Expression g;
    protected int type;


    public int getType() {
        if(g.getClass().getName()=="java.lang.Integer"){
            type=1;

        }
        return type;
    }

}
