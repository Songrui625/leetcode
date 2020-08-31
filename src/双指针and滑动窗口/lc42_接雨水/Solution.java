package 双指针and滑动窗口.lc42_接雨水;

public class Solution {
    public int trap(int[] height) {
        int left, right;
        int res = 0;
        left = right = 0;

        for (int i = 1; i < height.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }

            res += Math.min(left, right) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Solution solution = new Solution();
        System.out.println(solution.trap(height));


    }
}
