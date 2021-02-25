package 递归.lc509_斐波那契数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        // return fib(n - 1) + fib(n - 2);

        List<Integer> ansList = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            ansList.add(-1);
        }

        return helper(ansList, n);
    }

    private int helper(List<Integer> ansList, int n) {
        if (n < 2) return n;

        if (ansList.get(n) != -1) return ansList.get(n);

        ansList.set(n, helper(ansList, n - 1) + helper(ansList, n - 2));

        return ansList.get(n);
    }
}
