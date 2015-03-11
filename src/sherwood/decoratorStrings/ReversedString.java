package sherwood.decoratorStrings;

public class ReversedString implements OrderedCollection<Character> {
    
    private OrderedCollection<Character> string;
    
    public ReversedString (OrderedCollection<Character> string) {
        this.string = string;
    }

    @Override
    public Character at (int index) {
        return string.at(size() - index - 1);
    }

    @Override
    public int size () {
        return string.size();
    }
}
