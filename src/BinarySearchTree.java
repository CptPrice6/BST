import java.util.Comparator;
import java.util.ArrayList;

public class BinarySearchTree {

    private final Comparator cmp;

    private Node root;

    public BinarySearchTree(Comparator comparator) {
        cmp = comparator;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(Object key) {
        return search(root, key);
    }

    private Node search(Node node, Object key) {
        if (node == null || key.equals(node.getKeyValue()))
            return node;
        if (cmp.compare(key, node.getKeyValue()) < 0)
            return search(node.getSmaller(), key);
        else
            return search(node.getLarger(), key);
    }

    public void insert(Object keyVal) {
        root = insert(root, null, keyVal);
    }

    private Node insert(Node node, Node parent, Object key) {
        if (node == null) {
            node = new Node(key);

            if (parent != null)
                node.setParent(parent);

            return node;
        }

        if (cmp.compare(key, node.getKeyValue()) < 0) {
            Node newNode = insert(node.getSmaller(), node, key);
            node.setSmaller(newNode);
        } else if (cmp.compare(key, node.getKeyValue()) > 0) {
            Node newNode = insert(node.getLarger(), node, key);
            node.setLarger(newNode);
        } else {
            System.out.println("ERROR: NO duplicate key allowed.");
        }

        return node;
    }

    public static void printBinaryTree(Node node, int level) {
        if (node == null)
            return;

        printBinaryTree(node.getLarger(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");

            System.out.println("|---" + node.getKeyValue());
        } else
            System.out.println(node.getKeyValue());
        printBinaryTree(node.getSmaller(), level + 1);
    }

    public void fillPathSum(Node node) {
        fillPathSum(node, 0);
    }

    private void fillPathSum(Node node, int parentPathSum) {
        if (node == null)
            return;
        NumberObject num = (NumberObject) node.getKeyValue();
        int currentPathSum = parentPathSum + (Integer) num.getNum();
        num.setPathSum(currentPathSum);

        fillPathSum(node.getSmaller(), currentPathSum);
        fillPathSum(node.getLarger(), currentPathSum);
    }

    public void findPathSumInRange(int L1, int L2) {
        findPathSumInRange(root, L1, L2, new ArrayList());
    }

    private void findPathSumInRange(Node node, int L1, int L2, ArrayList<Node> path) {
        if (node == null)
            return;

        path.add(node);
        NumberObject num = (NumberObject) node.getKeyValue();
        if (node.getSmaller() == null && node.getLarger() == null) { // leaf node
            if (num.getPathSum() >= L1 && num.getPathSum() <= L2) {
                printPath(path, num.getPathSum());
            }
        } else {
            findPathSumInRange(node.getSmaller(), L1, L2, new ArrayList(path));
            findPathSumInRange(node.getLarger(), L1, L2, new ArrayList(path));
        }
    }

    private void printPath(ArrayList<Node> path, int totalPathSum) {
        for (int i = path.size() - 1; i > 0; i--) {
            System.out.print(path.get(i).getKeyValue().toString() + " -> ");
        }
        System.out.print(path.get(0).getKeyValue().toString());
        System.out.println(", total pathSum=" + totalPathSum);
    }

}
