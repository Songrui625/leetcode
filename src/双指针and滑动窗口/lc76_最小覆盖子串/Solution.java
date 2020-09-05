package 双指针and滑动窗口.lc76_最小覆盖子串;

import java.util.HashMap;

public class Solution {
//    public String minWindow(String s, String t) {
//        String res = "";
//        int len = Integer.MAX_VALUE;
//        int m = s.length();
//        int n = t.length();
//        int left = 0;
//        int right = 0;
//        int count = 0;
//        HashMap<Character, Integer> window = new HashMap<>();
//        HashMap<Character, Integer> want = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            Integer integer = want.get(s.charAt(i));
//            integer == null ? 0 : integer++;
//            want.put(s.charAt(i),integer);
//        }
//
//        while (right < m) {
//            char c = s.charAt(right);
//            right++;
//            if (want.get(c) != null) {
//                window.put(c, window.get(c)++);
//                if (window.get(c) == want.get(c)) {
//                    count++;
//                }
//            }
//
//            while (valid == want.size()) {
//                if (right - left < len) {
//                    start = left;
//                    len = right - left;
//                }
//
//                char d = s.charAt(left);
//
//                left++;
//
//                if (want.get(d) != null) {
//                    if (window.get(d) == want.get(d)) {
//                        valid--;
//                    }
//                    window.put(d, window.get(d)--);
//                }
//            }
//        }
//
//        return len ==Integer.MAX_VALUE ? "" :s.subString(start, len);
//    }
}
