package sherwood.decoratorStrings;

import java.util.*;

public interface OrderedCollection<K> {
    default K first () {
        return at(0);
    }

    default K last () {
        return at(size() - 1);
    }

    K at (int index);

    int size ();
    
    /**
     * @return whether or not K is in this collection
     */
    default boolean in(K k) {
        for (int i=0; i<size(); i++)
            if (at(i).equals(k))
                return true;
        return false;
    }

    /**
     * @return The first index containing K in this collection if K is in the collection, otherwise Optional.empty()
     */
    default Optional<Integer> search(K k) {
        return search(k, 0);
    }

    /**
     * @return The first index containing K in this collection beginning at index index if K is in the collection, otherwise Optional.empty()
     */
    default Optional<Integer> search(K k, int index) {
        for (int i=Math.max(0, index); i < size(); i++)
            if (at(i).equals(k))
                return Optional.of(i);
        return Optional.empty();
    }
}
