package lab4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.ListIterator;

public class Lab4 {

    public static LinkedList<Integer> testProblem1() {
        Random rand = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(rand.nextInt());
        }
        // sub problem a)
        long startTimea1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.set(i, linkedList.get(i) * 2);
        }
        long endTimea1 = System.currentTimeMillis();
        long durationa = endTimea1 - startTimea1;
        System.out
                .println("Time taken for sub problem a) using get/set: " + durationa + " milliseconds for N = 100000");
        // -----------------------------------------------------
        for (int i = 0; i < linkedList.size(); i++) { // here, we reset the list to original values
            linkedList.set(i, linkedList.get(i) / 2);
        }
        // -----------------------------------------------------
        // sub problem b) -- use a ListIterator and set() to safely replace elements
        // in-place
        long startTimeb1 = System.currentTimeMillis();
        ListIterator<Integer> listIt1 = linkedList.listIterator();
        while (listIt1.hasNext()) {
            int current = listIt1.next();
            listIt1.set(current * 2);
        }
        long endTimeb1 = System.currentTimeMillis();
        long durationb = endTimeb1 - startTimeb1;
        System.out.println(
                "Time taken for sub problem b) using iterator: " + durationb + " milliseconds  for N = 100000");
        // -----------------------------------------------------
        // sub problem c)
        // time comparison for N = 200000 elements
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 200000; i++) {
            list2.add(rand.nextInt());
        }
        long startTimea2 = System.currentTimeMillis();
        for (int i = 0; i < list2.size(); i++) {
            list2.set(i, list2.get(i) * 2);
        }
        long endTimea2 = System.currentTimeMillis();
        long durationa2 = endTimea2 - startTimea2;
        System.out
                .println("Time taken for sub problem c) using get/set: " + durationa2 + " milliseconds for N = 200000");

        for (int i = 0; i < list2.size(); i++) { // here, we reset the list to original values
            list2.set(i, list2.get(i) / 2);
        }

        long startTimeb2 = System.currentTimeMillis();
        ListIterator<Integer> listIt2 = list2.listIterator();
        while (listIt2.hasNext()) {
            int current = listIt2.next();
            listIt2.set(current * 2);
        }
        long endTimeb2 = System.currentTimeMillis();
        long durationb2 = endTimeb2 - startTimeb2;
        System.out.println("Time taken for sub problem c) using ListIterator.set: " + durationb2
                + " milliseconds  for N = 200000");
        // time comparison for N = 400000 elements
        LinkedList<Integer> list3 = new LinkedList<>();
        for (int i = 0; i < 400000; i++) {
            list3.add(rand.nextInt());
        }
        long startTimea3 = System.currentTimeMillis();
        for (int i = 0; i < list3.size(); i++) {
            list3.set(i, list3.get(i) * 2);
        }
        long endTimea3 = System.currentTimeMillis();
        long durationa3 = endTimea3 - startTimea3;
        System.out
                .println("Time taken for sub problem c) using get/set: " + durationa3 + " milliseconds for N = 400000");

        for (int i = 0; i < list3.size(); i++) { // here, we reset the list to original values
            list3.set(i, list3.get(i) / 2);
        }

        long startTimeb3 = System.currentTimeMillis();
        ListIterator<Integer> listIt3 = list3.listIterator();
        while (listIt3.hasNext()) {
            int current = listIt3.next();
            listIt3.set(current * 2);
        }

        long endTimeb3 = System.currentTimeMillis();
        long durationb3 = endTimeb3 - startTimeb3;
        System.out.println("Time taken for sub problem c) using ListIterator.set: " + durationb3
                + " milliseconds  for N = 400000");
        // -----------------------------------------------------
        return linkedList;
    }
    /*
     * explanation for time complexities of problem 1:
     * here's the output:
     * Time taken for sub problem a) using get/set: 38579 milliseconds for N =
     * 200000
     * Time taken for sub problem b) using ListIterator.set: 41 milliseconds for N =
     * 200000
     * Time taken for sub problem c) using ListIterator.set: 8 milliseconds for N =
     * 100000
     * Time taken for sub problem c) using get/set: 38579 milliseconds for N =
     * 200000
     * Time taken for sub problem c) using ListIterator.set: 41 milliseconds for N =
     * 200000
     * Time taken for sub problem c) using get/set: 288895 milliseconds for N =
     * 400000
     * Time taken for sub problem c) using ListIterator.set: 19 milliseconds for N =
     * 40000
     * 
     * 
     * it is clear that using an iterator is significantly faster than using get/set
     * that's because get(index) method in LinkedList has O(n) time complexity
     * and not also that, but we use these methods inside a loop that runs n times
     * making the overall time complexity O(n^2) for get/ set
     * 
     * 
     * but the iterator's next() method has O(1) time complexity
     * so the overall time complexity for using iterator is O(n)
     * making it much faster for large N values
     * 
     * that's why for N = 400000, the time taken for get/set is 288895 milliseconds
     * and for iterator it is only 19 milliseconds
     * 
     * 
     * 
     */

    public static void addSorted(LinkedList<Integer> list, int newElement) {
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int currentElement = iterator.next();
            if (newElement <= currentElement) {
                iterator.previous();
                iterator.add(newElement);
                return;
            }
        }
        list.addLast(newElement);
    }

    public static void testProblem2() {
        Random rnd = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        int prevnum = 0;
        for (int i = 0; i < 20; i++) {
            int currnum = prevnum + rnd.nextInt(10);
            list.add(currnum);
            prevnum = currnum;
        }
        Integer newElement = 55;
        addSorted(list, newElement);
        Iterator<Integer> iter = list.iterator();
        System.out.println("List after inserting " + newElement + ":");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    public static void testProblem3() {
        // Build a complete binary tree of height 3 (levels 0..3)
        // We'll use integers for node elements. Use the LinkedBinaryTree implementation
        // in this package.
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        // Add root
        Position<Integer> root = tree.addRoot(1);

        // Level 1
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
        tree.addRight(leftRight, 11);
        tree.addLeft(rightLeft, 12);
        tree.addRight(rightLeft, 13);
        tree.addLeft(rightRight, 14);
        tree.addRight(rightRight, 15);

        // Print required nodes to verify structure
        System.out.println("root: " + root.getElement());
        System.out.println("root left: " + tree.left(root).getElement());
        System.out.println("root right: " + tree.right(root).getElement());

        System.out.println("left child's left: " + tree.left(left).getElement());
        System.out.println("left child's right: " + tree.right(left).getElement());

        System.out.println("right child's left: " + tree.left(right).getElement());
        System.out.println("right child's right: " + tree.right(right).getElement());

        System.out.println("left-left child's children: " +
                tree.left(leftLeft).getElement() + ", " + tree.right(leftLeft).getElement());

        System.out.println("left-right child's children: " +
                tree.left(leftRight).getElement() + ", " + tree.right(leftRight).getElement());

        System.out.println("right-left child's children: " +
                tree.left(rightLeft).getElement() + ", " + tree.right(rightLeft).getElement());

        System.out.println("right-right child's children: " +
                tree.left(rightRight).getElement() + ", " + tree.right(rightRight).getElement());
        // Test countDescendants from AbstractTree
        System.out.println("\nDescendant counts:");
        System.out.println("root has descendants: " + tree.countDescendants(root));
        System.out.println("left has descendants: " + tree.countDescendants(left));
        System.out.println("left-left has descendants: " + tree.countDescendants(leftLeft));
        System.out.println("left-right has descendants: " + tree.countDescendants(leftRight));
    }

    public static void main(String[] args) {
        // your code here for problem 1 //
        // your comments here for problem 1
        System.out.println("problem 1 output:");
        testProblem1();

        System.out.println("problem 2 output:");

        testProblem2(); // 55 sayısını listeye ekliyor ve yazdırıyor. 55 sayısının sırayı bozup
                        // bozmadığına bakılmalı
        System.out.println();
        System.out.println("problem 3 output:");

        testProblem3(); //

    }
}
