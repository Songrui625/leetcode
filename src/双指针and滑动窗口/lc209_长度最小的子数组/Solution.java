package 双指针and滑动窗口.lc209_长度最小的子数组;


/**
 * 解题思想一：暴力求解，双重for循环枚举出所有的结果，遇到一次更小的就更新
 * 解题思想二：slide window
 * 左右指针指向第一个索引，记录窗口内的值，右指针不断右移，如果窗口内的值满足解
 * 则更新最优解，并把左指针右移。直至遍历完所有的解集。
 */

public class Solution {

    //暴力求解
//    public int minSubArrayLen(int s, int[] nums) {
//        int len = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum >= s && len > j - i + 1) {
//                    len = j - i + 1;
//                    break;
//                }
//            }
//        }
//
//        return len;
//    }

    //slide window: version: 2.0
    public int minSubArrayLen(int s, int[] nums) {
        int left, right;
        left = right = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            right++; //这里导致了长度为左闭右开

            while (sum >= s) {
                if (res > right - left) {
                    res = right - left;
                }
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

        //version:1.0
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int left, right;
//        int sum = 0;
//        int res = Integer.MAX_VALUE;
//        left = right = 0;
//        for (left = 0; left < nums.length; left++) {
//            sum = 0;
//            if (left == right && nums[left] >= s) {
//                return 1;
//            }
//            sum = nums[left];
//            right = left;
//            while (right < nums.length - 1) {
//                right++;
//                sum += nums[right];
//                if (sum >= s) {
//                    res = Math.min(res, right - left + 1);
//                    break;
//                }
//            }
//        }
//        if (res != Integer.MAX_VALUE) {
//            return res;
//        }
//        return 0;
//    }

    //version 2.0:
//    public int minSubArrayLen(int s, int[] nums) {
//
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, nums));
    }
}
