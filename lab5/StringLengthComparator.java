package lab5;

import java.util.Comparator;

/**
 * Comparator comparing strings by their lengths (shorter string is "smaller").
 */
public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        if (a == null && b == null)
            return 0;
        if (a == null)
            return -1;
        if (b == null)
            return 1;
        int cmp = Integer.compare(a.length(), b.length());
        if (cmp != 0)
            return cmp;
        // tie-breaker for deterministic ordering: fall back to lexicographic
        return a.compareTo(b);
    }
}
