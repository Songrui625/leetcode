package 数组.lc1_两数之和;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int leftNum = target - nums[i];
            /**
             * 一定要有元素的索引不是本身，因为返回的是两个不同的索引.
             * eg: nums = [3, 2, 4] , target = 6
             * 如果扫描到第一个元素的时候，由于3 + 3 = 6;
             * 此时会把会返回[0, 0]，这显然是错误的。
             */
            if (map.containsKey(leftNum) && map.get(leftNum) != i) {
                return new int[] {map.get(leftNum), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("不存在两数之和");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));

    }
}
