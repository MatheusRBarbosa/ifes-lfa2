/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.lfa.calc.data;

import java.util.Vector;

/**
 *
 * @author mathe
 */
public class Vetor extends Vetorial{
    public final Vector value;
    
    public Vetor(Vector v){
        this.value = v;
    }
    public Vetor(Long size){
        value = new Vector();
        for(int i=0;i<size;i++){
            this.value.add(Expr.NONE);
        }
    }
    
    @Override
    public String show() {
        return String.format("Vetor(%s)", String.valueOf(this.value));
    }
    
    @Override
    public Vector vectorValue() {
        return this.value;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
    
    public Literal get(int index){
        return (Literal)this.value.get(index);
    }
    
    public void set(Literal v, int index){
        this.value.add(index, v);
    }
    


}
