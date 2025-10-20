package lab3;


import java.util.Iterator;

public class Part2 {
    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        list.addLast(-1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Initial list: ");
        PrintList(list);
        System.out.println("\n-------------------------------");

        System.out.println("trying the set(E item) in the ElementIterator class");

        // You need an instance of Part2 to call the non-static TestSet method
        Part2 part2 = new Part2();
        part2.TestSetproblem1(list);

        System.out.println("\nList after TestSet: ");
        PrintList(list);
        System.out.println("\n--------------------------------");
        System.out.println("trying the TestSet method in the aray: [3; 8; 5; 12; 6; 2; 9]");
        System.out.println("Expected output: [6; 5; 2; 18]");
        LinkedPositionalList<Integer> list2 = new LinkedPositionalList<>();
        list2.addLast(3);
        list2.addLast(8);
        list2.addLast(5);
        list2.addLast(12);
        list2.addLast(6);
        list2.addLast(2);
        list2.addLast(9);
        part2.TestSet(list2);
        System.out.println("\nList after TestSet: ");
        PrintList(list2);

        

    }

    // TestSet is now a non-static instance method
    public void TestSetproblem1(LinkedPositionalList<Integer> L) {
        LinkedPositionalList<Integer>.ElementIterator it = (LinkedPositionalList<Integer>.ElementIterator) L.iterator();
        Integer elementToBeChanged = it.next();
        System.out.println("element to be changed: " + elementToBeChanged + " to 0");
        it.set(0);
    }

    public void TestSet(LinkedPositionalList<Integer> L) {
        LinkedPositionalList<Integer>.ElementIterator it = (LinkedPositionalList<Integer>.ElementIterator) L.iterator();
        while (it.hasNext()) {
            Integer current = it.next();
            if (current % 4 == 0) {
                it.remove();
                continue;
            }
            if (current % 3 == 0) {
                int newValue = current * 2;
                it.set(newValue);
                if (newValue % 4 == 0) {
                    it.remove();
                }
            }
        }

    }

    static void PrintList(LinkedPositionalList<Integer> L) {
        Iterator<Integer> iter = L.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
