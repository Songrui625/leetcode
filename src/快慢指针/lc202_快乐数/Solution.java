package 快慢指针.lc202_快乐数;

/**
 * 解题思想：快慢指针
 * 主要思路和循环链表类似，每一个平方和结果作为一个链表结点
 * 如果有环，说明不可能到1。
 * 如果没有环，就判断结果是否是1.
 * 
 */

public class Solution {
    private int count (int n) {
        int bit, sum;
        sum = 0;
        while (n != 0) {
            bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = count(slow);
            fast = count(fast);
            fast = count(fast);
        }while(slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
