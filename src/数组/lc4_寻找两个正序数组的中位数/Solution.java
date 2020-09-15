package 数组.lc4_寻找两个正序数组的中位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    暴力求解
    先合并两个链表，然后排序。
    根据数组长度的奇偶返回中位数
    时间复杂度：O（m + n），就是合并两个链表的复杂度
    空间复杂度：O（m + n），就是新的数组的大小
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] arr = new int[len];
        if (m == 0) {
            if (n % 2 == 0) {
                return (double) (nums2[n / 2 - 1] + nums2[n / 2]) / 2;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (double) (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
            } else {
                return nums1[m / 2];
            }
        }

        System.arraycopy(nums1, 0, arr, 0, m);
        System.arraycopy(nums2, 0, arr, m, n);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        if (len % 2 == 0) {
            return (double) (arr[len / 2 - 1] + arr[len / 2]) / 2;
        }
        return (double) arr[len / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));


    }
}
