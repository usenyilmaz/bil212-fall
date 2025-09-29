package doublylinkedlists;

public class DoublyLinkedList<E> {

    // MARK: - Inner Node Class
    /**
     * Bağlı listedeki her bir elemanı temsil eden iç sınıf.
     * Çift yönlü bağlı liste olduğu için hem bir sonrakine (next) hem de bir öncekine (previous)
     * işaret eden referanslara sahiptir.
     */
    private static class Node<E> {
        private E element;  // Bu düğümde saklanan veri
        private Node<E> previous; // Bir önceki düğüme referans
        private Node<E> next;     // Bir sonraki düğüme referans

        /**
         * Yeni bir düğüm (Node) oluşturucu.
         * @param e Bu düğümde saklanacak eleman.
         * @param p Bir önceki düğüm (predecessor).
         * @param n Bir sonraki düğüm (successor).
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            previous = p;
            next = n;
        }

        // Getter Metotları
        public E getElement() { return element; }
        public Node<E> getPrevious() { return previous; }
        public Node<E> getNext() { return next; }

        // Setter Metotları
        public void setPrevious(Node<E> p) { previous = p; }
        public void setNext(Node<E> n) { next = n; }
    }

    // MARK: - Class Instance Variables
    private Node<E> head; // Listenin başlangıcını işaret eden referans
    private Node<E> tail; // Listenin sonunu işaret eden referans
    private int size = 0; // Listedeki eleman sayısı

    // MARK: - Constructor
    /**
     * Boş bir DoublyLinkedList oluşturur.
     * head ve tail'i "sentinel" (koruyucu) düğümler olarak başlatır.
     */
    public DoublyLinkedList() {
        // head, bir sonraki elemanı tail olan bir başlangıç koruyucu düğümdür.
        head = new Node<>(null, null, null);
        // tail, bir önceki elemanı head olan bir bitiş koruyucu düğümdür.
        tail = new Node<>(null, head, null);
        head.setNext(tail); // head'in next'i tail'i gösterir.
    }

    // MARK: - Core Utility Method: addBetween
    /**
     * Listede iki belirli düğüm arasına yeni bir eleman ekler.
     *
     * @param e Eklenecek eleman.
     * @param predecessor Yeni düğümün hemen öncesindeki düğüm.
     * @param successor Yeni düğümün hemen sonrasındaki düğüm.
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // 1. Yeni düğümü oluştur
        Node<E> newest = new Node<>(e, predecessor, successor);
        // 2. predecessor'ın next'ini yeni düğüme ayarla
        predecessor.setNext(newest);
        // 3. successor'ın previous'unu yeni düğüme ayarla
        successor.setPrevious(newest);
        // 4. Boyutu artır
        size++;
    }

    // MARK: - Public Insertion/Deletion Methods (Yardımcı metotlar)

    /**
     * Listenin başına (head'den sonra) bir eleman ekler.
     * @param e Eklenecek eleman.
     */
    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    /**
     * Listenin sonuna (tail'den önce) bir eleman ekler.
     * @param e Eklenecek eleman.
     */
    public void addLast(E e) {
        addBetween(e, tail.getPrevious(), tail);
    }

    /**
     * Belirtilen düğümü listeden kaldırır.
     *
     * @param node Kaldırılacak düğüm.
     * @return Kaldırılan düğümdeki eleman.
     */
    private E remove(Node<E> node) {
        // Düğümün bir önceki ve bir sonraki düğümlerini al
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();

        // 1. predecessor'ın next'ini successor'a ayarla
        predecessor.setNext(successor);
        // 2. successor'ın previous'unu predecessor'a ayarla
        successor.setPrevious(predecessor);
        // 3. Boyutu azalt
        size--;

        // Bellek temizliği için referansları null yap (opsiyonel ama iyi pratik)
        node.setPrevious(null);
        node.setNext(null);

        // Kaldırılan elemanı döndür
        return node.getElement();
    }

    /**
     * Listenin başındaki (ilk gerçek) elemanı siler.
     * @return Kaldırılan eleman.
     */
    public E removeFirst() {
        if (isEmpty()) return null; // Liste boşsa
        return remove(head.getNext()); // head'in hemen sonrasındaki düğümü sil
    }

    /**
     * Listenin sonundaki (son gerçek) elemanı siler.
     * @return Kaldırılan eleman.
     */
    public E removeLast() {
        if (isEmpty()) return null; // Liste boşsa
        return remove(tail.getPrevious()); // tail'in hemen öncesindeki düğümü sil
    }

    // MARK: - Required Method: delete (Elemanın kendisini listeden siler)
    /**
     * Listede verilen elemanın *ilk* bulunduğu yeri bulur ve siler.
     *
     * @param e Silinecek eleman.
     * @return Silme işlemi başarılıysa true, eleman bulunamazsa false.
     */
    public boolean delete(E e) {
        Node<E> current = head.getNext(); // İlk gerçek düğümden başla
        while (current != tail) { // listenin sonuna (tail koruyucusuna) ulaşana kadar
            // Eleman null değilse ve eşitse (equals ile karşılaştır) VEYA ikisi de null ise
            if ((e != null && e.equals(current.getElement())) || (e == null && current.getElement() == null)) {
                remove(current); // Bulunan düğümü sil
                return true;     // Silme başarılı
            }
            current = current.getNext(); // Bir sonraki düğüme geç
        }
        return false; // Eleman listede bulunamadı
    }

    // MARK: - Required Method: search
    /**
     * Listede bir elemanın varlığını kontrol eder.
     *
     * @param e Aranacak eleman.
     * @return Eleman listede bulunuyorsa true, aksi halde false.
     */
    public boolean search(E e) {
        Node<E> current = head.getNext(); // İlk gerçek düğümden başla
        while (current != tail) { // Listenin sonuna (tail koruyucusuna) ulaşana kadar
            // Eleman null değilse ve eşitse VEYA ikisi de null ise
            if ((e != null && e.equals(current.getElement())) || (e == null && current.getElement() == null)) {
                return true; // Eleman bulundu
            }
            current = current.getNext(); // Bir sonraki düğüme geç
        }
        return false; // Eleman listede bulunamadı
    }

    // MARK: - Utility Methods
    /**
     * Listenin boş olup olmadığını kontrol eder.
     * @return Liste boşsa true, aksi halde false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Listenin boyutunu döndürür.
     * @return Listedeki eleman sayısı.
     */
    public int size() {
        return size;
    }

    // Liste içeriğini string olarak gösterir (Test amaçlı)
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head.getNext();
        while (current != tail) {
            sb.append(current.getElement());
            current = current.getNext();
            if (current != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // MARK: - Main Method (Test Sürüşü)
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println("Liste Başlangıcı: " + list); // []

        // Ekleme Metotları
        list.addLast("A");      // [A]
        list.addLast("B");      // [A, B]
        list.addFirst("Z");     // [Z, A, B]
        list.addBetween("X", list.head.getNext().getNext(), list.head.getNext().getNext().getNext()); // A ile B arasına X -> [Z, A, X, B]
        System.out.println("Ekleme Sonrası: " + list); // [Z, A, X, B]

        // Arama Metodu
        System.out.println("X'i ara: " + list.search("X"));  // true
        System.out.println("Y'yi ara: " + list.search("Y"));  // false

        // Silme Metodu (delete)
        list.delete("A"); // [Z, X, B]
        System.out.println("A silindikten sonra: " + list);
        list.delete("B"); // [Z, X]
        System.out.println("B silindikten sonra: " + list);
        System.out.println("Y'yi sil (yok): " + list.delete("Y")); // false

        // removeFirst/Last Metotları
        list.removeFirst(); // [X]
        System.out.println("removeFirst sonrası: " + list);
        list.removeLast();  // []
        System.out.println("removeLast sonrası: " + list);
        System.out.println("Boyut: " + list.size()); // 0
    }
}