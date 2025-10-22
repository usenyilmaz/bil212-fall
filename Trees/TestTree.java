package Trees;

import lab4.LinkedBinaryTree;
import lab4.Position;

import java.util.Iterator;
import java.util.LinkedList;

public class TestTree {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 2);
        Position<Integer> right = tree.addRight(root, 3);

        // Level 2
        Position<Integer> leftLeft = tree.addLeft(left, 4);
        Position<Integer> leftRight = tree.addRight(left, 5);
        Position<Integer> rightLeft = tree.addLeft(right, 6);
        Position<Integer> rightRight = tree.addRight(right, 7);

        // Level 3 (children of level 2 nodes) — make sure height is 3 by adding one
        // more level
        tree.addLeft(leftLeft, 8);
        tree.addRight(leftLeft, 9);
        tree.addLeft(leftRight, 10);
        System.out.println(tree.isEmpty());
        Iterator<Position<Integer>> posZ = (Iterator<Position<Integer>>) tree.positions();
        Position p = null;
        while(posZ.hasNext()){
            p = posZ.next();
            System.out.println(p);
            if(p.getElement().equals(6)){
                break;
            }
        }
        System.out.println(tree.remove(p));

    }
}
