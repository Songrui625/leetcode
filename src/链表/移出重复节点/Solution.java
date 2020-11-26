package 链表.移出重复节点;

import 链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();

        ListNode dummy = new ListNode(0);
        ListNode q = dummy;
        while (head != null) {
            if (!set.contains(head.val) ) {
                set.add(head.val);
                q.next = new ListNode(head.val);
                q = q.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
