package sherwood.decoratorStrings;

import java.util.*;

public final class String implements OrderedCollection<Character> {
    
    private final char[] value;
    
    public String(final char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }
    
    public String(OrderedCollection<Character> string) {
        value = new char[string.size()];
        for (int i=0; i<string.size(); i++)
            value[i] = string.at(i);
    }

    @Override
    public Character at (int index) {
        if (index < 0 || index >= size())
            throw new StringIndexOutOfBoundsException();
        return value[index];
    }

    @Override
    public int size () {
        return value.length;
    }

    @Override
    public java.lang.String toString() {
        return new java.lang.String(value);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedCollection))
            return false;
        OrderedCollection p = (OrderedCollection) o;
        if (p.size() != size())
            return false;
        for (int i=0; i<size(); i++)
            if (!(p.at(i) instanceof Character) || p.at(i) != at(i))
                return false;
        return true;
    }

    @Override
    public int hashCode () {
        return Arrays.hashCode(value);
    }
}
