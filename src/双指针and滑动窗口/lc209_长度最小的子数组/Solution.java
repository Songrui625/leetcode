package 双指针and滑动窗口.lc209_长度最小的子数组;

public class Solution {

    //version:1.0
    public int minSubArrayLen(int s, int[] nums) {
        int left, right;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        left = right = 0;
        for (left = 0; left < nums.length; left++) {
            sum = 0;
            if (left == right && nums[left] >= s) {
                return 1;
            }
            sum = nums[left];
            right = left;
            while (right < nums.length - 1) {
                right++;
                sum += nums[right];
                if (sum >= s) {
                    res = Math.min(res, right - left + 1);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, nums));
    }
}
