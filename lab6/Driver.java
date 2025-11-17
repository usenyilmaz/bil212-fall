package lab6;  
public class Driver {

    public static void main(String[] args) {
        // Natural order integer heap
        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>();

        // Initial insertions
        heap.insert(9, "A");
        heap.insert(4, "B");
        heap.insert(8, "C");
        heap.insert(1, "D");
        heap.insert(6, "E");
        heap.insert(3, "F");
        heap.insert(7, "G");
        heap.insert(2, "H");
        heap.insert(5, "I");
        heap.insert(10, "J");

        System.out.println("Initial heap (as tree):");
        printHeapAsTree(heap);
        printHeapKeys(heap);

        // Test setKey
        heap.setKey(3, 12 );
        System.out.println("\nAfter setKey(3, 12):");
        printHeapAsTree(heap);
        printHeapKeys(heap);

        // Test lessThanOrEqual
        System.out.println("\nKeys <= 8:");
        heap.lessThanOrEqual(8);

        // Test: removeEntry
        System.out.println("\nTesting removeEntry:");

        int removeIndex = 2; // örnek olarak index 2'yi kaldırıyoruz
        Integer removedKey = heap.removeEntry(removeIndex);
        System.out.println("Removed key at index " + removeIndex + ": " + removedKey);

        System.out.println("\nHeap after removal (as tree):");
        printHeapAsTree(heap);
        printHeapKeys(heap);

        System.out.println("\nAll tests completed.");
    }

    private static void printHeapKeys(HeapPriorityQueue<Integer, String> heap) {
        System.out.print("Heap keys: [ ");
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.heap.get(i).getKey() + " ");
        }
        System.out.println("]");
    }

    private static void printHeapAsTree(HeapPriorityQueue<Integer, String> heap) {
        int n = heap.size();
        if (n == 0) {
            System.out.println("(empty heap)");
            return;
        }

        int level = 0;
        int index = 0;
        while (index < n) {
            int nodesInLevel = (int) Math.pow(2, level);
            int end = Math.min(index + nodesInLevel, n);

            // Girinti (heap’in seviyesine göre)
            int spacing = (int) Math.pow(2, Math.max(0, 4 - level)); // daha düzgün görünüm için sabit oran
            System.out.print(" ".repeat(Math.max(0, spacing / 2)));

            for (int i = index; i < end; i++) {
                System.out.print(heap.heap.get(i).getKey());
                System.out.print(" ".repeat(spacing));
            }

            System.out.println();
            index = end;
            level++;
        }
    }
}
