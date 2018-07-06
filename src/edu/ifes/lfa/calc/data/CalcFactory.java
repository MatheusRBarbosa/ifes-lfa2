package edu.ifes.lfa.calc.data;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author jefferson
 */
public class CalcFactory {
    
    public static Int makeInt(long x) {
        return new Int(x);
    }
    
    public static Int makeInt(String s) {
        return makeInt(Long.parseLong(s));
    }
    
    public static Decimal makeDecimal(double x) {
        return new Decimal(x);
    }
    
    public static Decimal makeDecimal(String s) {
        return makeDecimal(Double.parseDouble(s));
    }
    
    public static Expr makeCompositeExpr(Expr fn, Expr... args) {
        return makeCompositeExpr(fn, Arrays.asList(args));
    }

    public static Expr makeCompositeExpr(Expr fn, List<Expr> args) {
        return new CompositeExpr(fn, args);
    }
    
    public static Expr makeVariable(String name) {
        return new Variable(name);
    }
    
    public static Expr makeAssign(String varName, Expr value) {
        return new Assignment(varName, value);
    }
    
    public static Expr makeBool(boolean value) {
        if (value) return Bool.VERUM;
        else return Bool.FALSUM;
    }
    
    public static Expr makeIfThen(Expr cond, Expr thenExpr) {
        return new IfExpr(cond, thenExpr);
    }
    
    public static Expr makeIfThenElse(Expr cond, Expr thenExpr, Expr elseExpr) {
        return new IfExpr(cond, thenExpr, elseExpr);
    }

    public static Expr makeWhile(Expr cond, Expr doExpr) {
        return new WhileExpr(cond, doExpr);
    }
    
    public static Expr makeBlock(List<Expr> body) {
        return new BlockExpr(body);
    }
    
    public static Expr makeCharSeq(String text) {
        return new CharSeq(text);
    }
    
    public static Expr makeFunctionDecl(String name, List<String> params, Expr body) {
        UserFunction f = new UserFunction(params, body);
        Declaration d = new Declaration(name, f);
        return d;
    }
    
    public static Expr makeVector(Vector v){
        return new Vetor(v);
    }
    
    public static Expr makeVector(Long size){
        return new Vetor(size);
    }
    
    public static Expr makeVector(Vector v, Long index){
        Integer i = index.intValue();
        return new Vetor(v).get(i);
    }
    
    public static Expr makeVector(Vector v, Literal value, Long index){
        Integer i = index.intValue();
        return new Vetor(v).set(value, i);

    }
    
}
