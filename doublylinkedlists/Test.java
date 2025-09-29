package doublylinkedlists;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<Human> list = new DoublyLinkedList<>();
        Human h1 = new Human("Mary", 25);
        Human h2 = new Human("John", 25);
        Human h3 = new Human("Jane", 25);
        Human h4 = new Human("Jane", 25);
        Human h5 = new Human("Jane", 25);

        list.addFirst(h5);
        list.addFirst(h4);
        list.addFirst(h3);
        list.addFirst(h2);
        list.addFirst(h1);



    }
}
