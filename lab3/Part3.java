package lab3;


import java.util.Iterator;

import lab3.LinkedPositionalList;

public class Part3 {

    public static void main(String[] args) {
        LinkedPositionalList<Integer> L = new LinkedPositionalList<>();
        L.addLast(1);
        L.addLast(8);
        L.addLast(5);
        L.addLast(12);
        L.addLast(6);
        L.addLast(5);
        L.addLast(2);

        LinkedPositionalList<Integer> P = new LinkedPositionalList<>();
        P.addLast(1);
        P.addLast(3);
        P.addLast(4);
        P.addLast(6);

        System.out.println("Initial List L: " + L);
        System.out.println("Indices to change P: " + P);
        
        setPositions(L, P);

        System.out.println("List L after setPositions: " + L);
    }
    public static void setPositions(LinkedPositionalList<Integer> L, LinkedPositionalList<Integer> P) {
        LinkedPositionalList<Integer>.ElementIterator iteratorL = (LinkedPositionalList<Integer>.ElementIterator) L.iterator();
        LinkedPositionalList<Integer>.ElementIterator iteratorP = (LinkedPositionalList<Integer>.ElementIterator) P.iterator();

        int currentLIndex = 0;
        int nextPIndex = 0;
        
        if (iteratorP.hasNext()) {
            nextPIndex = iteratorP.next();
        } else {
            return; // P is empty, nothing to do
        }

        while (iteratorL.hasNext()) {
            Integer currentElement = iteratorL.next();

            if (currentLIndex == nextPIndex) {
                iteratorL.set(currentElement * 2);

                if (iteratorP.hasNext()) {
                    nextPIndex = iteratorP.next();
                }
            }
            currentLIndex++;
        }
    }
    
   
    static void PrintList(LinkedPositionalList<Integer> L) {
        Iterator<Integer> iter = L.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}