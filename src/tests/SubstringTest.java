package tests;

import sherwood.decoratorStrings.Substring;
import sherwood.decoratorStrings.String;

public class SubstringTest {
    
    public void test() {
        String t = new String(new char[]{'a', 'b', 'c'});
        assert t.equals(new Substring.FromBeginning(t, 0));
        assert new String(new char[]{'b', 'c'}).equals(new Substring.FromBeginning(t, 1));
        assert new String(new char[]{'c'}).equals(new Substring.FromBeginning(t, 2));
        assert new String(new char[0]).equals(new Substring.FromBeginning(t, 3));
        
        assert t.equals(new Substring.FromEnd(t, 3));
        assert new String(new char[]{'a', 'b'}).equals(new Substring.FromEnd(t, 2));
        assert new String(new char[]{'a'}).equals(new Substring.FromEnd(t, 1));
        assert new String(new char[]{}).equals(new Substring.FromEnd(t, 0));

        String hello = new String("hello world".toCharArray());
        assert new String(new Substring.FromBeginning(new Substring.FromEnd(hello, 5), 2)).equals(new String("hello world".substring(2, 5).toCharArray()));
    }
}
