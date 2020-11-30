package 链表.lc2_两数相加;

import 链表.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p, q;
        p = l1;
        q = l2;
        //增加呀节点便于插入操作
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //用carry来记录进位
        int carry = 0;
        //条件不是 p != null && q != null 的原因是每个对应结点都要操作，空的结点将用0来代替
        while (p != null || q != null) {
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;
            int sum = val1 + val2 + carry;
            //只能有一位有效位，所以要对10取模
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            //记录进位，在下个结点相加的时候加上低位传过来的进位
            carry = sum/10;
            cur.next = newNode;
            cur = newNode;
            //正常遍历，p本身可能为null，此时不动
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        //如果结点都空了，还有低位传过来的进位，进行最后的求和
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
