package edu.ifes.lfa.calc.data;

/**
 *
 * @author jefferson
 */
public abstract class Expr implements Show {

    public static final Expr NONE = new Expr() {
        
        @Override
        public Expr eval(Context ctx) {
            return this;
        }

        @Override
        public String show() {
            return "None";
        }
        
        @Override
        public String toString() {
            return "()";
        }
        
    };
    
    public abstract Expr eval(Context ctx);
    
    @Override
    public abstract String show();
    
}
