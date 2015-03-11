package sherwood.decoratorStrings;

public interface OrderedCollection<K> {
    default K first () {
        return at(0);
    }

    default K last () {
        return at(size() - 1);
    }

    K at (int index);

    int size ();
    
    default K[] value () {
        K[] k = (K[]) new Object[size()];
        for (int i=0; i<size(); i++)
            k[i] = at(i);
        return k;
    }
}
