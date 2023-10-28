package Leetcode.L202305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 力扣17
 * 回溯用法
 * @author yangf073
 * @date 2023/5/14 22:26
 */
public class L0514_17 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return;
        }
        Map<Character, String> phoneMap = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        // 回溯方法
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        System.out.println(combinations);;
    }

    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index + 1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
