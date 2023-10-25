public class four {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //объединяем
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //дополнительный узелочек
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        //пока оба не пустые
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        //если кто-то пустой, то остальное просто присоединяем
        if (l1 != null) {current.next = l1;}
        if (l2 != null) {current.next = l2;}
        return dummy.next;
    }

    //выводим
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {System.out.print(" ");}
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //создаем два списка
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(8);
        list1.next.next.next.next = new ListNode(12);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(7);
        list2.next.next.next.next = new ListNode(9);

        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println("Объединенный список:");
        printList(mergedList);
    }
}