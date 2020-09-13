package 数学.lc7_整数反转;

/**
 * 考虑溢出问题：
 *  正数：2 1 4 7 4 8 3 6 4 7
 *       2 1 4 7 4 8 3 6 5 8
 *       2 1 4 7 4 8 3 6 4 8
 *       2 1 4 7 4 8 3 6 4 9
 *  负数：- 2 1 4 7 4 8 3 6 4 7
 *       - 2 1 4 7 4 8 3 6 5 7
 *       - 2 1 4 7 4 8 3 6 4 6
 *  考虑倒数第一位和倒数第二位：
 *      当倒数第二位大于4时，一定会溢出
 *      当倒数第二位等于4时，考虑倒数第一位
 *
 */

public class Solution {
    public int reverse(int x) {
        int m, bit;
        m = bit = 0;
        while (x != 0) {
            bit = x % 10;
            //判断是否 大于 最大32位整数
            if (m>214748364 || (m==214748364 && bit>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (m<-214748364 || (m==-214748364 && bit<-8)) {
                return 0;
            }
            m = m*10 + bit;
            x /= 10;
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(
                -1534236469));


    }

}
