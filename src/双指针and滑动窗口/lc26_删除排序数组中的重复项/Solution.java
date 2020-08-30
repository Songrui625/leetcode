package 双指针and滑动窗口.lc26_删除排序数组中的重复项;

/**
 * 解题思想：快慢指针遍历。
 * 由于需要返回的只是数组的长度，实际上就是统计数组中不同的数字的个数
 * 具体算法：如果快指针和慢指针所指元素相同，那快指针后移。
 * 如果快指针和慢指针所指元素不同，说明遇到了一个新的元素，那就需要加1计数。（实际上只能用O(1)的空间复杂度。）
 * 所以可以考虑把快指针所指的元素赋给慢指针后一个位置。
 * 重复上述比较，直至比较结束
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int left = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[left] == nums[j]) {
                left++;
                nums[left] = nums[j];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
