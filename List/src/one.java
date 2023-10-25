public class one {
    static class ListNode {
        int value;
        ListNode next; //узел односвязного списка

        public ListNode(int value) {
            this.value = value;
        }
    }

    //вставка элемента в список
    public static ListNode insertIntoSorted(ListNode head, int element) {
        //новый узел
        ListNode Node = new ListNode(element);

        //если список пустой или элемент меньше основного, то присваиваем
        if (head == null || element < head.value) {
            Node.next = head;
            return Node;
        }

        //проверям элементы
        ListNode current = head;
        while (current.next != null && current.next.value < element) {
            current = current.next;
        }

        //вставляем элемент
        Node.next = current.next;
        current.next = Node;

        return head;
    }

    //выводим список
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("Список с добавленным элементом: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        //заполняем список
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);

        //добавляем элемент
        head = insertIntoSorted(head, 7);
        printList(head);
    }
}