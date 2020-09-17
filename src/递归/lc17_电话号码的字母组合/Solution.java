package 递归.lc17_电话号码的字母组合;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
//    List<String> list = new ArrayList<>();
//
//    public static Map<Character, String> saveLetter() {
//        Map<Character, String> map = new HashMap<>();
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        return map;
//    }
//
//    public List<String> letterCombinations(String digits) {
//        int n = digits.length();
//        Map<Character, String> map = saveLetter();
//        for (int i = 0; i < n; i++) {
//            char c = digits.charAt(i);
//            if (map.containsKey(c)) {
//                String value = map.get(c);
//                int m = value.length();
//                for (int j = 0; j < m; j++) {
//                    list.add(new String(String.valueOf(digits.charAt(i) + value.charAt(j))));
//                }
//            }
//        }
//        return list;
//    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){

        if(index == digits.length()){
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        return;
    }

    public static void main(String[] args) {
        String digits = "23";

        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(digits));
    }
}
