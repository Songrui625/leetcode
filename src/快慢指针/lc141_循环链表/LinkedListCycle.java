package 快慢指针.lc141_循环链表;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode low, fast;
        low = fast = head;
        //fast.next != null 判断当快指针以及到链表尾的时候，如果下一个为空说明不循环。
        //否则循环体中fast.next.next就会造成非法访问内存
        while(fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode current, temp;
        ListNode newNode = new ListNode(2);
        current = head;
        temp = newNode;
        current.next = newNode;
        current = newNode;
        newNode = new ListNode(0);
        current.next = newNode;
        current = newNode;
        newNode = new ListNode(4);
        current.next = newNode;
        current = newNode;
        current.next = temp;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
    }
}
