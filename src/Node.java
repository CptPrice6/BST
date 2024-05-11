public class Node {

    private Object keyValue;
    private Node parent;
    private Node smaller;
    private Node larger;

    public Node(Object keyValue) {
        this.keyValue = keyValue;
    }

    public Object getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(Object keyValue) {
        this.keyValue = keyValue;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getSmaller() {
        return smaller;
    }

    public void setSmaller(Node smaller) {
        this.smaller = smaller;
    }

    public Node getLarger() {
        return larger;
    }

    public void setLarger(Node larger) {
        this.larger = larger;
    }

    @Override
    public String toString() {
        return getKeyValue().toString();
    }

    public boolean isSmaller() {
        return getParent() != null && this == getParent().getSmaller();
    }

    public boolean isLarger() {
        return getParent() != null && this == getParent().getLarger();
    }

    public Node minimum() {
        Node node = this;
        while (node.getSmaller() != null) {
            node = node.getSmaller();
        }
        return node;
    }

    public Node maximum() {
        Node node = this;
        while (node.getLarger() != null) {
            node = node.getLarger();
        }
        return node;
    }

    public Node successor() {
        if (getLarger() != null) {
            return getLarger().minimum();
        }
        Node node = this;
        while (node.isLarger()) {
            node = node.getParent();
        }
        return node.getParent();
    }

    public Node predecessor() {
        if (getSmaller() != null) {
            return getSmaller().maximum();
        }
        Node node = this;
        while (node.isSmaller()) {
            node = node.getParent();
        }
        return node.getParent();
    }

}
