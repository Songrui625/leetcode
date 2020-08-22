package com.yjz.ThreeSumCloest;

import java.util.Arrays;

public class ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        int dist = Integer.MAX_VALUE;
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j ++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int sub = (target - sum) < 0 ? Math.abs(target - sum) : target - sum;
                    if (sub < dist) {
                        dist = sub;
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 2, 1, -4};
        System.out.println(Arrays.toString(nums));
        int target = 1;
        ThreeSumCloest threeSumCloest = new ThreeSumCloest();
        System.out.println(threeSumCloest.threeSumClosest(nums, target));
    }
}
