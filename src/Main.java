public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(new CmpNumberObject());

        bst.insert(new NumberObject(5));
        bst.insert(new NumberObject(2));
        bst.insert(new NumberObject(7));
        bst.insert(new NumberObject(1));
        bst.insert(new NumberObject(3));
        bst.insert(new NumberObject(6));
        bst.insert(new NumberObject(8));
        bst.insert(new NumberObject(4));
        bst.insert(new NumberObject(9));

        bst.fillPathSum(bst.getRoot());
        bst.printBinaryTree(bst.getRoot(), 0);

        // bst.findPathSumInRange(100, 400); // no nodes
        bst.findPathSumInRange(10, 30); // all nodes
        // bst.findPathSumInRange(1, 10); // some nodes

    }
}
