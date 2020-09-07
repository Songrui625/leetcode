package 双指针and滑动窗口.lc121_买卖股票的最佳时机;

/**
 * 1、暴力求解：二重循环，求 max{prices[j] - prices[i]}
 * 2、slide window:
 *
 */

public class Solution {
    //暴力求解
//    public int maxProfit(int[] prices) {
//
//        int res = Integer.MIN_VALUE;
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                res = Math.max(res, prices[j] - prices[i]);
//            }
//        }
//
//        return Math.max(res, 0); //可能所有的值都是小于0那就返回0
//    }

    //slide window
    public int maxProfit(int[] prices) {
        int left, right;
        left = right = 0;
        int res = Integer.MIN_VALUE;
        int n = prices.length;
        while (right < n) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            res = Math.max(res, prices[right] - prices[left]);
            right++;
        }
        return Math.max(res, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));

        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices2));

    }
}
