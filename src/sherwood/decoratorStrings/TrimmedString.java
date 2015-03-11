package sherwood.decoratorStrings;

import java.lang.*;

/**
 *  a class representing a String trimmed of all white space at the beginning and end
 */
public class TrimmedString implements OrderedCollection<Character> {
    
    private OrderedCollection<Character> string;
    private boolean trimmed;
    
    public TrimmedString(OrderedCollection<Character> string) {
        this.string = string;
    }
    
    @Override
    public Character at (int index) {
        if (!trimmed) trim();
        return string.at(index);
    }

    @Override
    public int size () {
        if (!trimmed) trim();
        return string.size();
    }

    private void trim () {
        int i = 0;
        while (Character.isWhitespace(string.at(i)))
            i++;
        string = new Substring.FromBeginning(string, i);
        i = string.size();
        while (Character.isWhitespace(string.at(i)))
            i--;
        string = new Substring.FromEnd(string, i);
    }
}
