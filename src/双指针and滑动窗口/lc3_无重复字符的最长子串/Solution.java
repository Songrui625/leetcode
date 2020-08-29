package 双指针and滑动窗口.lc3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        int n = s.length();
//        int right = 0;
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            if (i != 0) {
//                set.remove(s.charAt(i));
//            }
//            while (right != n && !set.contains(s.charAt(right))) {
//                set.add(s.charAt(right));
//                right++;
//            }
//            maxLen = Math.max(maxLen, right - i);
//        }
//        return maxLen;
//    }

    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        int maxLen = 0;
        int n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            char ch = s.charAt(j);
            //这里相当于左指针所指字符和右指针所指字符重复时，则左指针向右移，保证窗口没有重复的字符。
            i = Math.max(i, pos[ch]);
            maxLen = Math.max(maxLen, j - i + 1);
            pos[ch] = j + 1; //记录下如果当前字符的下一个位置。
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
