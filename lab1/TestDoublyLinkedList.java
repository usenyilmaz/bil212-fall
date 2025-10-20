package lab1;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        // 1. Empty list tests
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        System.out.println("Empty list: " + list1);
        // Expected: Empty list: ()

        list1.addInTheMiddle(100); // should just add
        System.out.println("Add in the middle of empty: " + list1);
        // Expected: Add in the middle of empty: (100)

        // 2. Single element list
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.addLast(50);
        System.out.println("\nSingle element list: " + list2);
        // Expected: Single element list: (50)

        list2.addInTheMiddle(200); // should add after the only element
        System.out.println("After addInTheMiddle: " + list2);
        // Expected: After addInTheMiddle: (50, 200)

        list2.moveMinToFront(); // min is 50 already front → unchanged
        System.out.println("After moveMinToFront: " + list2);
        // Expected: After moveMinToFront: (50, 200)

        // 3. Even number of elements
        DoublyLinkedList<Integer> list3 = new DoublyLinkedList<>();
        for (int i = 1; i <= 6; i++) list3.addLast(i * 10); // (10, 20, 30, 40, 50, 60)
        System.out.println("\nEven-sized list: " + list3);
        // Expected: Even-sized list: (10, 20, 30, 40, 50, 60)

        list3.addInTheMiddle(999); // middle index=3, insert after 3rd element → after 30
        System.out.println("After addInTheMiddle: " + list3);
        // Expected: After addInTheMiddle: (10, 20, 30, 999, 40, 50, 60)

        // 4. Odd number of elements
        DoublyLinkedList<Integer> list4 = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) list4.addLast(i * 5); // (5, 10, 15, 20, 25)
        System.out.println("\nOdd-sized list: " + list4);
        // Expected: Odd-sized list: (5, 10, 15, 20, 25)

        list4.addInTheMiddle(777); // size=5 → middle=3 → insert after 15
        System.out.println("After addInTheMiddle: " + list4);
        // Expected: After addInTheMiddle: (5, 10, 15, 777, 20, 25)

        // 5. moveMinToFront with min in middle
        DoublyLinkedList<Integer> list5 = new DoublyLinkedList<>();
        list5.addLast(10);
        list5.addLast(14);
        list5.addLast(5);   // min
        list5.addLast(46);
        list5.addLast(24);
        list5.addLast(31);
        System.out.println("\nOriginal list (min inside): " + list5);
        // Expected: Original list (min inside): (10, 14, 5, 46, 24, 31)

        list5.moveMinToFront();
        System.out.println("After moveMinToFront: " + list5);
        // Expected: After moveMinToFront: (5, 10, 14, 46, 24, 31)

        // 6. moveMinToFront with duplicates
        DoublyLinkedList<Integer> list6 = new DoublyLinkedList<>();
        list6.addLast(7);
        list6.addLast(3);   // first min
        list6.addLast(9);
        list6.addLast(3);   // duplicate min
        list6.addLast(12);
        System.out.println("\nOriginal list (with duplicates): " + list6);
        // Expected: Original list (with duplicates): (7, 3, 9, 3, 12)

        list6.moveMinToFront(); // moves the first "3" to front
        System.out.println("After moveMinToFront: " + list6);
        // Expected: After moveMinToFront: (3, 7, 9, 3, 12)

        // 7. moveMinToFront with min already at front
        DoublyLinkedList<Integer> list7 = new DoublyLinkedList<>();
        list7.addLast(1); // already min
        list7.addLast(4);
        list7.addLast(7);
        System.out.println("\nOriginal list (min already at front): " + list7);
        // Expected: Original list (min already at front): (1, 4, 7)

        list7.moveMinToFront(); // unchanged
        System.out.println("After moveMinToFront: " + list7);
        // Expected: After moveMinToFront: (1, 4, 7)
    }
}
