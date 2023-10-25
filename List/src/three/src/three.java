public class three {
    Node head;

    //добавляем в конец
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {current = current.next;}

        current.next = newNode;
    }

    //объединаяем 2 списка
    public void mergeLists(Node list1, Node list2) {
        if (list1 == null && list2 == null) {return;}

        if (list1 == null) {
            head = list2;
            return;
        }

        if (list2 == null) {
            head = list1;
            return;
        }

        Node current = list1;
        while (current.next != null) {current = current.next;}

        current.next = list2;
        head = list1;
    }

    //выводим
    public void printList() {
        Node current = head;
        System.out.print("Объединенный список: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        three list1 = new three();
        three list2 = new three();

        //добавляем элементы в 1 список
        list1.addNode(1);
        list1.addNode(3);
        list1.addNode(7);
        list1.addNode(4);

        //во 2 список
        list2.addNode(2);
        list2.addNode(4);
        list2.addNode(5);
        list2.addNode(8);
        list2.addNode(1);

        //объединяем
        list1.mergeLists(list1.head, list2.head);
        list1.printList();
    }
}