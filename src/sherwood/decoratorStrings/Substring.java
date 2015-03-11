package sherwood.decoratorStrings;

public class Substring {

    public static class FromBeginning implements OrderedCollection<Character> {

        private OrderedCollection<Character> string;
        private int beginningIndex;

        public FromBeginning (OrderedCollection<Character> string, int beginningIndex) {
            if (beginningIndex < 0 || beginningIndex > string.size())
                throw new StringIndexOutOfBoundsException();
            this.string = string;
            this.beginningIndex = beginningIndex;
        }

        @Override
        public Character at (int index) {
            return string.at(index + beginningIndex);
        }

        @Override
        public int size () {
            return string.size() - beginningIndex;
        }
    }
    
    public static class FromEnd implements OrderedCollection<Character> {

        private FromBeginning fromBeginning;

        public FromEnd(OrderedCollection<Character> string, int endIndex) {
            fromBeginning = new FromBeginning(new ReversedString(string), string.size() - endIndex);
        }

        @Override
        public Character at (int index) {
            return fromBeginning.at(size() - index - 1);
        }

        @Override
        public int size () {
            return fromBeginning.size();
        }
    }
}
