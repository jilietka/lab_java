public class five {
    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    //находим средний элемент
    public static int findMiddle(ListNode head) {
        if (head == null) {return -1;}

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;         //медленный указатель + 1
            fastPointer = fastPointer.next.next;    //быстрый указатель + 2
        }

        return slowPointer.data;
    }

    public static void main(String[] args) {
        //создаем связанный список
        ListNode head = new ListNode(10);
        head.next = new ListNode(11);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(13);
        head.next.next.next.next = new ListNode(14);
        head.next.next.next.next.next = new ListNode(15);

        int middle = findMiddle(head);
        System.out.println("Средний элемент: " + middle);
    }
}