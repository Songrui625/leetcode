package 递归.lc322_零钱兑换;

import java.util.Arrays;

class Solution {

    private int ans = 0;
    private boolean isEnd;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        Arrays.sort(coins);
        int maxIdx = coins.length -1;
        helper(coins, maxIdx, amount);


        if (isEnd == false) return -1;
        return ans;
    }

    private void helper(int[] coins, int maxIdx, int amount) {
        if (maxIdx < 0 || amount == 0) return;
        int count = amount / coins[maxIdx];
        if (count != 0) {
            amount = amount - (count * coins[maxIdx]);
            ans += count;
        }
        maxIdx--;
        helper(coins, maxIdx, amount);
        if (amount == 0 ) isEnd = true;
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};

        Solution solution = new Solution();
        int res = solution.coinChange(coins, 6249);
        System.out.println(res);
    }
}
