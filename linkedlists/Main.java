package linkedlists;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Person> list = new SinglyLinkedList<>();
        Person p1 = new Person("john", 32);
        Person p2 = new Person("abraham", 29);
        Person p3 = new Person("marie", 3);
        Person p4 = new Person("stella", 60);
        Person p5 = new Person("atabilgisayar", 18);
        System.out.println("----------- trying addfirst method------------");
        list.addfirst(p4);
        list.addfirst(p3);
        list.addfirst(p2);
        list.addfirst(p1);
        list.printlist();
        System.out.println("----------------------------------------------");
        System.out.println("------------ trying addlast method------------");
        list.addlast(p5);
        list.printlist();
        System.out.println("----------------------------------------------");
        System.out.println("------------ trying Removefirst method------------");
        list.RemoveFirst();
        list.printlist();
        System.out.println("----------------------------------------------");
        System.out.println("------------ trying Removelast method------------");
        list.RemoveLast();
        list.printlist();
        System.out.println("----------------------------------------------");
    }
}
