import src.BinaryTree2;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryTree2<Integer> btree = new BinaryTree2<>();
        btree.add(42);
        btree.add(44);
        btree.add(43);
        btree.add(36);
        btree.add(16);
        btree.add(2);
        btree.add(1);
        btree.add(10);
        btree.add(6);
        btree.add(39);
        btree.add(20);
        btree.add(38);
        btree.add(32);
        btree.add(17);
        btree.add(40);
        btree.print();
    }
}
