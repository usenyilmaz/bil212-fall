package lab5;

public class testHeap {
    public static void main(String[] args) {

        System.out.println("-----------------------------Question 3------------------------");
        HeapPriorityQueue<Integer, Integer> hpInt = new HeapPriorityQueue<>();
        int[] values = { 20, 5, 15, 22, 3, 18, 30, 1, 7, 12, 17, 19, 25, 2, 9 };
        for (int v : values)
            hpInt.insert(v, v);

        System.out.println("Integer heap inorder printed with dots indicating depth:");
        hpInt.printInOrder();

        System.out.println("-----------------------------Question 4------------------------");

        HeapPriorityQueue<String, String> hp = new HeapPriorityQueue<>(new StringLengthComparator());
        String[] strs = { "apple", "a", "banana", "kiwi", "strawberry", "pear", "grape", "orange", "fig", "pineapple",
                "plum", "melon" };
        for (String s : strs)
            hp.insert(s, s);

        System.out.println("\nString heap (ordered by string length) inorder printed with dots indicating depth:");
        hp.printInOrder();

        // Perform 3 removeMin operations and print the heap after each removal
        for (int i = 1; i <= 3; i++) {
            Entry<String, String> removed = hp.removeMin();
            System.out.println(
                    "\nAfter removeMin #" + i + ", removed: " + (removed != null ? removed.getValue() : "null"));
            hp.printInOrder();
        }
    }
}
