package edu.ifes.lfa.calc.data;

import static edu.ifes.lfa.calc.Utils.unescapeString;
import static edu.ifes.lfa.calc.data.CalcFactory.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Vector;

/**
 *
 * @author jefferson
 */
public class Functions {
    
    public static final Operator PLUS = new Operator("+", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Int && y instanceof Int) {
              Int a = (Int) x;
              Int b = (Int) y;
              return makeInt(a.value + b.value);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              double c = a.decValue() + b.decValue();
              return makeDecimal(c);
          }
          else {
              throw new IllegalArgumentException("Addition for non-numeric arguments.");
          }
      }
    };
    
    public static final Operator MINUS = new Operator("-", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Int && y instanceof Int) {
              Int a = (Int) x;
              Int b = (Int) y;
              return makeInt(a.value - b.value);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              double c = a.decValue() - b.decValue();
              return makeDecimal(c);
          }
          else {
              throw new IllegalArgumentException("Subtraction for non-numeric arguments.");
          }
      }
    };
    
    public static final Operator TIMES = new Operator("*", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Int && y instanceof Int) {
              Int a = (Int) x;
              Int b = (Int) y;
              return makeInt(a.value * b.value);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              double c = a.decValue() * b.decValue();
              return makeDecimal(c);
          }
          else {
              throw new IllegalArgumentException("Multiplication for non-numeric arguments.");
          }
      }
    };
    
    public static final Operator DIVIDE = new Operator("/", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Int && y instanceof Int) {
              Int a = (Int) x;
              Int b = (Int) y;
              return makeInt(a.value / b.value);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              double c = a.decValue() / b.decValue();
              return makeDecimal(c);
          }
          else {
              throw new IllegalArgumentException("Division for non-numeric arguments.");
          }
      }
    };
    
    public static final Operator EXP = new Operator("^", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Int && y instanceof Int) {
              Int a = (Int) x;
              Int b = (Int) y;
              Double c = Math.pow(a.value.doubleValue(), b.value.doubleValue());
              return makeInt(c.longValue());
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              double c = Math.pow(a.decValue(), b.decValue());
              return makeDecimal(c);
          }
          else {
              throw new IllegalArgumentException("Division for non-numeric arguments.");
          }
      }
    };
    
    public static final Operator UMINUS = new Operator("-", 1) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          if (x instanceof Int) {
              Int a = (Int) x;
              return makeInt(-a.value);
          }
          else if (x instanceof Decimal) {
              Decimal a = (Decimal) x;
              return makeDecimal(-a.value);
          }
          else {
              throw new IllegalArgumentException("Negation for non-numeric arguments.");
          }
      }
    };
    
    public static final Function SIN = new SysFunction(1) {
        @Override
        protected Expr fn(List<Literal> values) {
            double x = ((Numeric) values.get(0)).decValue();
            double y = Math.sin(x);
            return makeDecimal(y);
        }        
    };
    
    public static final Function COS = new SysFunction(1) {
        @Override
        protected Expr fn(List<Literal> values) {
            double x = ((Numeric) values.get(0)).decValue();
            double y = Math.cos(x);
            return makeDecimal(y);
        }        
    };
    
    public static final Function TAN = new SysFunction(1) {
        @Override
        protected Expr fn(List<Literal> values) {
            double x = ((Numeric) values.get(0)).decValue();
            double y = Math.tan(x);
            return makeDecimal(y);
        }        
    };
    
    public static final Function PRINTLN = new SysFunction(0, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            for (Literal l: values) {
                System.out.printf("%s ", l);
            }
            System.out.println();
            return makeInt(values.size());
        }        
    };
    
    public static final Operator AND = new Operator("&&", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Bool && y instanceof Bool) {
              Bool a = (Bool) x;
              Bool b = (Bool) y;
              boolean c = a.value && b.value;
              return makeBool(c);
          }
          else {
              throw new IllegalArgumentException("Conjunction must have boolean arguments.");
          }
      }
    };
    
    public static final Operator OR = new Operator("||", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Bool && y instanceof Bool) {
              Bool a = (Bool) x;
              Bool b = (Bool) y;
              boolean c = a.value || b.value;
              return makeBool(c);
          }
          else {
              throw new IllegalArgumentException("Disjunction must have boolean arguments.");
          }
      }
    };
    
    public static final Operator NOT = new Operator("!", 1) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          if (x instanceof Bool) {
              Bool a = (Bool) x;
              boolean c = !a.value;
              return makeBool(c);
          }
          else {
              throw new IllegalArgumentException("Logic negation must have boolean arguments.");
          }
      }
    };
    
    public static final Operator EQU = new Operator("==", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);          
          boolean eq = false;
          if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              eq = Objects.equals(a.decValue(), b.decValue());
          }
          else if(x instanceof Vetorial && y instanceof Vetorial){
              Vetorial a = (Vetorial) x;
              Vetorial b = (Vetorial) y;
              eq = Objects.equals(a.vectorValue(), b.vectorValue());
          }
          else {
              eq = x.equals(y);
          }
          return makeBool(eq);
      }
    };
    
    public static final Operator NEQ = new Operator("!=", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Bool ans = (Bool) EQU.fn(args);
          return ans.neg();
      }
    };
    
    public static final Operator LT = new Operator("<", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Bool && y instanceof Bool) {
              Bool a = (Bool) x;
              Bool b = (Bool) y;
              boolean c = !a.value && b.value;
              return makeBool(c);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              boolean lt = a.decValue() < b.decValue();
              return makeBool(lt);
          }
          else if (x instanceof CharSeq && y instanceof CharSeq) {
              CharSeq a = (CharSeq) x;
              CharSeq b = (CharSeq) y;
              boolean lt = a.compareTo(b) < 0;
              return makeBool(lt);
          }
          else {
              String err = String.format("Cannot compare values: %s and %s.", x, y);
              throw new IllegalArgumentException(err);
          }
      }
    };
    
    public static final Operator GT = new Operator(">", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Literal x = args.get(0);
          Literal y = args.get(1);
          if (x instanceof Bool && y instanceof Bool) {
              Bool a = (Bool) x;
              Bool b = (Bool) y;
              boolean gt = a.value && !b.value;
              return makeBool(gt);
          }
          else if (x instanceof Numeric && y instanceof Numeric) {
              Numeric a = (Numeric) x;
              Numeric b = (Numeric) y;
              boolean gt = a.decValue() > b.decValue();
              return makeBool(gt);
          }
          else if (x instanceof CharSeq && y instanceof CharSeq) {
              CharSeq a = (CharSeq) x;
              CharSeq b = (CharSeq) y;
              boolean lt = a.compareTo(b) > 0;
              return makeBool(lt);
          }
          else {
              String err = String.format("Cannot compare values: %s and %s.", x, y);
              throw new IllegalArgumentException(err);
          }
      }
    };
    
    public static final Operator LEQ = new Operator("<=", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Bool eq = (Bool) EQU.fn(args);
          Bool lt = (Bool) LT.fn(args);
          boolean leq = eq.value || lt.value;
          return makeBool(leq);
      }
    };
    
    public static final Operator GEQ = new Operator("<=", 2) {
      @Override
      protected Expr fn(List<Literal> args) {
          Bool eq = (Bool) EQU.fn(args);
          Bool gt = (Bool) GT.fn(args);
          boolean geq = eq.value || gt.value;
          return makeBool(geq);
      }
    };
    
    public static final Function LENGTH = new SysFunction(1) {
        @Override
        protected Expr fn(List<Literal> values) {
            CharSeq y =  new CharSeq(((Text)values.get(0)).stringValue());
            return makeInt(y.len());
        }        
    };
    
    public static final Function CHARAT = new SysFunction(2) {
        @Override
        protected Expr fn(List<Literal> values) {
            CharSeq y =  new CharSeq(((Text)values.get(0)).stringValue());
            int z = Integer.valueOf(values.get(1).toString());
            return makeCharSeq(y.charAt(z));
        }        
    };
    
    public static final Function SUBSTRING = new SysFunction(3) {
        @Override
        protected Expr fn(List<Literal> values) {
            CharSeq y =  new CharSeq(((Text)values.get(0)).toString());
            int z = Integer.valueOf(values.get(1).toString());
            int w = Integer.valueOf(values.get(2).toString());
            return makeCharSeq("\""+y.tiraAspasIniFim().substring(z, w)+"\"");
        }        
    };
    
    public static final Function CONCAT = new SysFunction(2, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            StringBuilder sb = new StringBuilder();
            for (Literal l: values) {
                CharSeq y =  new CharSeq(((Text)l).toString());
                sb.append(y.tiraAspasIniFim());
            }
            return makeCharSeq(sb.toString());
        }        
    };
    
    public static final Function FORMAT = new SysFunction(1, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            CharSeq s = (CharSeq) values.get(0);
            values.remove(0);
            Object[] objetos = new Object[values.size()];
            int cont = 0;
            for(Literal l: values){
                if(l instanceof Int){
                    Long i = ((Int)l).intValue();
                    objetos[cont] = i;
                }
                if(l instanceof Decimal){
                    double d = ((Decimal) l).decValue();
                    objetos[cont] = d;
                } 
                if(l instanceof CharSeq){
                    String str = l.toString();
                    System.out.println("entrou3");
                    objetos[cont] = str;
                }
                cont++;
            }
            Formatter formatter = new Formatter();
            String fmt = formatter.format(s.toString(), objetos).toString();
            return makeCharSeq(fmt);
        }        
    };
    
    public static final Function VECTOR = new SysFunction(0, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            Vector v = new Vector();
            for(Literal valor: values){
                v.add(valor);
            }
            return makeVector(v);
        }        
    };
    
    public static final Function MAKEVECTOR = new SysFunction(1) {
        @Override
        protected Expr fn(List<Literal> values) {
            return makeVector(((Numeric)values.get(0)).intValue());
        }        
    };
    
    public static final Function GET = new SysFunction(2){
        @Override
        protected Expr fn(List<Literal> values) {
            return makeVector(((Vetorial)values.get(0)).vectorValue(),((Numeric)values.get(1)).intValue());
        } 
    };
    
    public static final Function SET = new SysFunction(3){
        @Override
        protected Expr fn(List<Literal> values) {
            return makeVector(((Vetorial)values.get(0)).vectorValue(),values.get(1), ((Numeric)values.get(2)).intValue());
        } 
    };
    
    public static final Function SIZE = new SysFunction(1){
        @Override
        protected Expr fn(List<Literal> values) {
            Vector v = ((Vetorial)values.get(0)).vectorValue();
            return makeInt(v.size());
        } 
    };
}
