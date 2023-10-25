public class two {
    public static Node swapNodes(Node head, int value1, int value2) {
        //список не пустой
        if (head == null || value1 == value2) {return head;}

        Node p1 = null;
        Node p2 = null;
        Node c1 = head;
        Node c2 = head;

        //смотрим, что надо менять
        while (c1 != null && c1.date != value1) {
            p1 = c1;
            c1 = c1.next;
        }

        while (c2 != null && c2.date != value2) {
            p2 = c2;
            c2 = c2.next;
        }

        //если найдет только 1 элемент, то нам это не подходит
        if (c1 == null || c2 == null) {return head;}

        //меняем элементы
        if (p1 != null) {p1.next = c2;} else {head = c2;}

        if (p2 != null) {p2.next = c1;} else {head = c1;}

        Node temp = c1.next;
        c1.next = c2.next;
        c2.next = temp;

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.date + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(9);

        System.out.println("Заданный список:");
        printList(head);

        head = swapNodes(head, 2, 8);

        System.out.println("Список, в котором элементы поменялись:");
        printList(head);
    }
}