package src;
//import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList1<Integer> newlist = new LinkedList1<>();
        newlist.add(10);
        newlist.add(25);
        newlist.add(1);
        newlist.add(3);
        newlist.add(41);
        newlist.print();
        newlist.revert();
        newlist.print();
        LinkedList2<Integer> list2 = new LinkedList2<>();
        list2.add(1);
        list2.add(9);
        list2.add(2);
        list2.add(8);
        list2.add(5);
        list2.add(3);
        list2.print();
        list2.revert3();
        list2.print();
        list2.qsort2();
        list2.print();
    }
}
