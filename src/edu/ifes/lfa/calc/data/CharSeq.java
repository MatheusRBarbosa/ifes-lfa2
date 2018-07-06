package edu.ifes.lfa.calc.data;

import static edu.ifes.lfa.calc.Utils.unescapeString;
import static java.lang.String.format;
import java.util.Objects;

/**
 *
 * @author jefferson
 */
public class CharSeq extends Text implements Comparable<CharSeq> {

    public final String value;
    
    public CharSeq(String value) {
        this.value = value;
    }

    @Override
    public String show() {
        return format("CharSeq(%s)", this.value);
    }
    
    @Override
    public String toString() {
        return (this.value.substring(1, this.value.length() - 1)).replace("\\n", " ").replace("\\t", "    ").replace("\\\"", "\"");
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof CharSeq) {
            CharSeq that = (CharSeq) other;
            return this.value.equals(that.value);
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public int compareTo(CharSeq o) {
        return value.compareTo(o.value);
    }
    
    public int len() {
        String y = this.value;
        return y.length();
    }
    
    public String charAt(int n) {
        String y = this.value;
        String z = Character.toString(y.charAt(n));
        return z;
    }
    
    public String substring(int ini, int fim) {
        String y = this.value;
        return y.substring(ini, fim);
    }

    @Override
    public String stringValue() {
        return (this.value.substring(1, this.value.length() - 1)).replace("\\n", " ").replace("\\t", "    ").replace("\\\"", "\"");
    }

}
