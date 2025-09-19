package linkedlists;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> nextNode){
            next = nextNode;
        }
    }
    public int size(){return size;}
    public SinglyLinkedList(){}
    public boolean isEmpty(){return size == 0;}
    public E first(){
        if(isEmpty()){return null;}
        return head.getElement();
    }
    public E last(){
        if(isEmpty()){return null;}
        return tail.getElement();
    }

    public void addfirst(E e){
//        Node<E> newest = new Node<E>(e, null);
//        newest.setNext(head);
//        head = newest;
//        if(isEmpty()){
//            tail = head;
//        }
//        size++;
        head = new Node<E>(e, head);
        if(isEmpty()){tail = head;}
        size++;
    }
    public void addlast(E e){
        Node<E> newest = new Node(e, null);
        if(isEmpty()){
            head = newest;
        }
        else{
            tail.setNext(newest);
        }
        size++;
    }
    public E RemoveFirst(){
        if(isEmpty()){return null;}
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()){tail = null;}
        return answer;
    }
    public E RemoveLast(){
        Node<E> curr = head;
        while (curr.getNext().getNext() != null) { //sondan bir önceki eleman
            curr = curr.getNext();
        }
        E answer = tail.getElement();
        curr.setNext(null);
        tail = curr;
        size--;
        if(isEmpty()){tail = null;}
        return answer;
    }



    public void printlist(){
        Node<E> curr = head;
        while(curr.getNext() != null){
            System.out.println(curr.getElement().toString());
            curr = curr.getNext();
        }
        System.out.println(curr.getElement().toString());
    }
}
