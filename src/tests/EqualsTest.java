package tests;

import sherwood.decoratorStrings.String;

public class EqualsTest {

    public void test () {
        assert new String(new char[]{'a', 'b', 'c'}).equals(new String(new char[]{'a', 'b', 'c'}));
        assert new String(new char[0]).equals(new String(new char[0]));
    }
}
