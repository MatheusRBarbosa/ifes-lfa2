package edu.ifes.lfa.calc.data;

import static edu.ifes.lfa.calc.Utils.unescapeString;
import static edu.ifes.lfa.calc.data.CalcFactory.*;
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
    
    public static final Function FORMAT = new SysFunction(1, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            CharSeq s = (CharSeq) values.get(0);
            values.remove(0);
            Object[] xs = values.toArray();
//            String fmt = format(s.value, xs);
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
    
    public static final Function CHARAT = new SysFunction(1, Optional.empty()) {
        @Override
        protected Expr fn(List<Literal> values) {
            String x = unescapeString(values.get(0).toString()).replace("\\\"", "");
            String y = Character.toString(x.charAt(0));
            return makeCharSeq(y);
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
}
