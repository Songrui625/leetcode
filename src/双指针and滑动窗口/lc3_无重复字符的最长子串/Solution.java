package 双指针and滑动窗口.lc3_无重复字符的最长子串;

import java.util.HashMap;

public class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null) {
//            return 0;
//        }
//        int len = s.length();
//        if (len == 1) {
//            return 1;
//        }
//        int maxLen = 0;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (s.charAt(i) == s.charAt(j) || s.charAt(j) == s.charAt(j-1)) {
//                    if (maxLen < j - i) {
//                        maxLen = j - i;
//                    }
//                    break;
//                }
//                if (j == len - 1) {
//                    maxLen = j - i + 1;
//                }
//            }
//        }
//        if (maxLen == 0) {
//            maxLen = len;
//        }
//
//        return maxLen;
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        int len = s.length();
        for(int i = 0; i < len; i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
