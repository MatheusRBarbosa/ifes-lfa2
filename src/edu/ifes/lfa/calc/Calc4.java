package edu.ifes.lfa.calc;

import edu.ifes.lfa.calc.CalcParser.ProgramContext;
import edu.ifes.lfa.calc.data.Context;
import edu.ifes.lfa.calc.data.Expr;
import edu.ifes.lfa.calc.data.Functions;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author jefferson
 */
public class Calc4 {
    
    private static final String PS1 = "calc[%d]> ";
    private static final String PS2 = "....| ";
    private static final String PSDBG = "debug> ";
    private static final String PSANS = " ans[%d]> %s\n";
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        boolean debug = (args.length > 0 && args[0].equals("--debug"));
        int count = 1;
        
        System.out.println("Calculadora v.0.1 -- LFA -- Campus Serra do Ifes");
        System.out.printf(PS1, count);
        
        Context ctx = makeGlobalContext();
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = readExpression(scan);
            if (line.equals(":q")) {
                System.exit(0);
            }
            ANTLRInputStream input = new ANTLRInputStream(new StringReader(line));
            CalcLexer lexer = new CalcLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CalcParser parser = new CalcParser(tokens);
            ProgramContext ans = parser.program();
            
            Expr value = Expr.NONE;
            for (Expr e: ans.sttms) {
            
                if (debug) {
                    System.out.printf("%s[%s]\n", PSDBG, e.show());
                }

                value = e.eval(ctx);
            }
            System.out.printf(PSANS, count, value);
            
            count += 1;
            System.out.println();
            System.out.printf(PS1, count);
        }
    }
    
    private static String readExpression(Scanner s) {
        StringBuilder sb = new StringBuilder();
        String t = s.nextLine();
        if (t.trim().equals("{:")) {
            System.out.printf(PS2);
            t = s.nextLine().trim();
            while (!t.equals(":}")) {
                sb.append(t);
                System.out.printf(PS2);
                t = s.nextLine().trim();
            }
        }
        else {
            sb.append(t);
        }
        return sb.toString();
    }

    private static Context makeGlobalContext() {
        Context ctx = new Context();
        ctx.put("sin", Functions.SIN);
        ctx.put("cos", Functions.COS);
        ctx.put("tan", Functions.TAN);
        ctx.put("println", Functions.PRINTLN);
        ctx.put("length", Functions.LENGTH);
        ctx.put("charat", Functions.CHARAT);
        ctx.put("vector", Functions.VECTOR);
        ctx.put("makevector", Functions.MAKEVECTOR);
        return ctx;
    }
    
}
