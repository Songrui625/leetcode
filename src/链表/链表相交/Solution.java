package 链表.链表相交;

import 链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：两趟遍历
 * 将链表A所有结点放进一个HashSet中。
 * 对链表B进行遍历，如果结点存在HashSet中，那这个结点就是相交结点，直接返回。
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if (!set.contains(headB)) {
                headB = headB.next;
                continue;
            }
            return headB;
        }

        return null;
    }

}
