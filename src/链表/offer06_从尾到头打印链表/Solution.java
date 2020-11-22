package 链表.offer06_从尾到头打印链表;

import 链表.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路一：递归
 * 递归到最后一个结点，返回前加上结点的值，但是要注意最后一次，递归结束后还要加上返回结点的值。
 */

public class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        List<Integer> arr = new LinkedList<>();
        ListNode ret = reverse(head, arr);
        arr.add(ret.val);
        int[] res = new int[arr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    public ListNode reverse(ListNode head, List<Integer> arr) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverse(head.next, arr);
        arr.add(ret.val);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        Solution solution = new Solution();
        int[] ints = solution.reversePrint(head);
        System.out.println(Arrays.toString(ints));
    }
}
