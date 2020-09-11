package 链表.lc142_环形链表;

import java.util.HashSet;
import java.util.Set;

class ListNode {
     int val;
     ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    /**
     * 解题思路：一次遍历
     * 遍历每个结点，加入到set中。
     * 每次判断当前结点是否存在set中，如果存在说明当前结点就是第一个循环结点
     * @param head
     * @return
     */
    //Version:1.0
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p;
        p = head;
        Set<ListNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p  = p.next;
            if (set.contains(p)) {
                return p;
            }
        }
        return null;
    }

}
