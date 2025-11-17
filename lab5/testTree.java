package lab5;

public class testTree {
    public static void main(String[] args) {
        System.out.println("-----------------------------Question 1------------------------");
        LinkedBinaryTree<String> t1 = new LinkedBinaryTree<>();

        String s1 = "A";
        String s2 = "B";
        String s3 = "C";
        String s4 = "D";
        String s5 = "E";
        String s6 = "F";
        String s7 = "G";
        String s8 = "H";
        String s9 = "I";
        String s10 = "J";

        t1.addRoot(s1);
        Position<String> p1 = t1.root();

        // build a sample binary tree using the remaining strings
        Position<String> p2 = t1.addLeft(p1, s2); // B
        Position<String> p3 = t1.addRight(p1, s3); // C

        Position<String> p4 = t1.addLeft(p2, s4); // D
        Position<String> p5 = t1.addRight(p2, s5); // E

        Position<String> p6 = t1.addLeft(p3, s6); // F
        Position<String> p7 = t1.addRight(p3, s7); // G

        Position<String> p8 = t1.addLeft(p4, s8); // H
        Position<String> p9 = t1.addRight(p4, s9); // I
        Position<String> p10 = t1.addLeft(p5, s10); // J

        System.out.println("total depth: " + t1.totalDepth());

        System.out.println("-----------------------------Question 2------------------------");

        // Build a second tree T2 that is morphable to T1 by swapping some children
        LinkedBinaryTree<String> t2 = new LinkedBinaryTree<>();
        t2.addRoot(s1);
        Position<String> q1 = t2.root();

        // swap children of root compared to t1: put C as left, B as right
        Position<String> q3 = t2.addLeft(q1, s3); // C
        Position<String> q2 = t2.addRight(q1, s2); // B

        // For node that was D (left-left of t1), in t2 it's under C's left or right
        // depending on swaps;
        // we'll create a structure that is morphable to t1 by swapping B and G's
        // children, etc.
        Position<String> q6 = t2.addLeft(q3, s6); // F
        Position<String> q7 = t2.addRight(q3, s7); // G

        Position<String> q4 = t2.addLeft(q2, s4); // D
        Position<String> q5 = t2.addRight(q2, s5); // E

        Position<String> q8 = t2.addLeft(q4, s8); // H
        Position<String> q9 = t2.addRight(q4, s9); // I
        Position<String> q10 = t2.addLeft(q5, s10); // J

        System.out.println("T1 and T2 morphable? " + morphable(t1, t2));

    }

    public static boolean morphable(BinaryTree<String> T1, BinaryTree<String> T2) {
        // If both trees are empty, they're morphable
        if (T1.isEmpty() && T2.isEmpty())
            return true;
        // If only one is empty, not morphable
        if (T1.isEmpty() || T2.isEmpty())
            return false;

        return morphableAt(T1.root(), T2.root(), T1, T2);
    }

    // helper that works on positions; T1 and T2 are passed to access children via
    // the BinaryTree interface
    private static boolean morphableAt(Position<String> p1, Position<String> p2,
            BinaryTree<String> T1, BinaryTree<String> T2) {
        if (p1 == null && p2 == null)
            return true;
        if (p1 == null || p2 == null)
            return false;
        // check element equality
        if (!p1.getElement().equals(p2.getElement()))
            return false;

        Position<String> a1 = T1.left(p1);
        Position<String> b1 = T1.right(p1);
        Position<String> a2 = T2.left(p2);
        Position<String> b2 = T2.right(p2);

        // Case 1: no swap at this node
        boolean noSwap = morphableAt(a1, a2, T1, T2) && morphableAt(b1, b2, T1, T2);
        if (noSwap)
            return true;
        // Case 2: swap children at this node
        boolean swap = morphableAt(a1, b2, T1, T2) && morphableAt(b1, a2, T1, T2);
        return swap;
    }
}
