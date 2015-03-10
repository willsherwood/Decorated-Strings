public interface OrderedCollection<K> {
    default K first () {
        return at(0);
    }

    default K last () {
        return at(size() - 1);
    }

    K at (int index);

    int size ();
}
