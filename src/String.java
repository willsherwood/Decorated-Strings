import java.util.*;

public final class String implements OrderedCollection<Character> {
    
    private final char[] value;
    
    public String(final char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }
    
    public char[] characters() {
        return Arrays.copyOf(value, value.length);
    } 
    
    @Override
    public java.lang.String toString() {
        return new java.lang.String(value);
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
}
