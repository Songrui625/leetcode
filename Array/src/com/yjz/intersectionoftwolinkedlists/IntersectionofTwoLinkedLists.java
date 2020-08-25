package com.yjz.intersectionoftwolinkedlists;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p, q;
        p = headA;
        q = headB;
        while (p != null) {
            while (q != null) {
                if (p == q)
                    return q;
                q = q.next;
            }
            q = headB;
            p = p.next;
        }
        return null;
    }
    
}
