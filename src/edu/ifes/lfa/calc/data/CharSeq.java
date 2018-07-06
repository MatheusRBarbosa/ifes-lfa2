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
        return format("CharSeq(%s)", unescapeString(value));
    }
    
    @Override
    public String toString() {
        return value;
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
        String y = this.value.replace("\\n", "n").replace("\\t", "t").replace("\"", "");
        return y.length();
    }

    @Override
    public String stringValue() {
        return this.value;
    }

}
