package 链表.lc142_环形链表;

import 链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 解题思路：一次遍历
     * 遍历每个结点，加入到set中。
     * 每次判断当前结点是否存在set中，如果存在说明当前结点就是第一个循环结点
     * @param head
     * @return
     */
    //Version:1.0
//    public ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode p = head;
//        Set<ListNode> set = new HashSet<>();
//        while (p != null) {
//            set.add(p);
//            p  = p.next;
//            if (set.contains(p)) {
//                return p;
//            }
//        }
//        return null;
//    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast)
                break;
        }

        if (low != fast)
            return null;
        fast = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
            if (low == fast)
                break;
        }

        return low;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next = head.next;

        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(head);
        System.out.println(listNode.val);

    }

}
