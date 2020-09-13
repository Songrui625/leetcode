package 数组.lc739_每日温度;

import java.util.Arrays;

public class Solution {
    //暴力求解：version:1.0
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        for (int i = 0 ; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                }
                if (j == n - 1) {
                    res[i] = 0;
                }
            }
        }
        return res;
    }

        public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(T)));
    }
}
