public class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node leftChild, rightChild;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(char ch, int freq, Node leftChild, Node rightChild) {
        this.ch = ch;
        this.freq = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}