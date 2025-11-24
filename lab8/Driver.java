package lab8;

public class Driver {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        // 1. EKLEME VE DISPLAY TESTİ
        System.out.println("--- 1. Ekleme ve Display ---");
        // Ağacın şekli şöyle olacak:
        //       50
        //      /  \
        //    20    80
        //   /  \     \
        // 10   30     90
        int[] keys = {50, 20, 80, 10, 30, 90};
        for (int k : keys) {
            map.put(k, null);
        }
        map.display(); // Ağacı çiz

        // 2. SİLME TESTİ (REMOVE)
        System.out.println("--- 2. Remove Testi (20 siliniyor) ---");
        map.remove(20); // 20'yi sil
        map.display();  // Tekrar çiz (20 gitmiş, yerine 10 veya 30 gelmiş olmalı)

        // 3. STANDART METODLAR (Tek Seferlik Test)
        System.out.println("--- 3. Standart Metodlar ---");
        // Mevcut Ağaç elemanları: 10, 30, 50, 80, 90

        System.out.println("firstEntry (Beklenen 10): " + map.firstEntry().getKey());
        System.out.println("lastEntry  (Beklenen 90): " + map.lastEntry().getKey());

        // 50 sayısına göre testler
        System.out.println("lowerEntry(50)   (Beklenen 30): " + map.lowerEntry(50).getKey());
        System.out.println("higherEntry(50)  (Beklenen 80): " + map.higherEntry(50).getKey());
        System.out.println("floorEntry(50)   (Beklenen 50): " + map.floorEntry(50).getKey());
        System.out.println("ceilingEntry(45) (Beklenen 50): " + map.ceilingEntry(45).getKey());

        System.out.print("subMap(30, 90)   (Beklenen 30 50 80): ");
        for (Entry<Integer, String> e : map.subMap(30, 90)) {
            System.out.print(e.getKey() + " ");
        }
        System.out.println();

        // 4. LAB ÖZEL METODLARI (Tek Seferlik Test)
        System.out.println("\n--- 4. Lab Özel Metodları ---");

        // countLessThan(50): 50'ye eşit veya küçük olanlar -> 10, 30, 50. (Toplam 3 adet)
        System.out.println("countLessThan(50)      (Beklenen 3): " + map.countLessThan(50));

        // inOrderPredecessor(50): 50'den bir önceki sayı -> 30
        System.out.println("inOrderPredecessor(50) (Beklenen 30): " + map.inOrderPredecessor(50));

        // inOrderSuccessor(50): 50'den bir sonraki sayı -> 80
        System.out.println("inOrderSuccessor(50)   (Beklenen 80): " + map.inOrderSuccessor(50));
    }

}