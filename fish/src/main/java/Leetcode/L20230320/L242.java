package Leetcode.L20230320;

import java.util.HashMap;

/**
 * @Category L20230320
 * @Description 【功能描述】
 * @Author kkk
 * @Since 2023/3/20 11:19
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class L242 {
    public static void main(String[] args) {
        String s = "anagrgm";
        String t = "nagaram";
        // 定义一个长度为26的数组，代表字母A-Z，索引代表A-Z的位置，如A对应0
        // 值对应字母出现的次数，如A出现了2次，为：索引为0，值为2
        int[] records = new int[26];
        // 遍历字符串s，进行统计
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a'] ++;
        }
        // 遍历字符串t，进行比对
        for (int i = 0; i < t.length(); i++) {
            records[t.charAt(i) - 'a'] --;
        }
        // 遍历数组，查看是否有不为0的，有不为0的代表不一致
        for (int res : records) {
            if (res != 0) {
                // return false;
                // System.out.println("不一致");
            }
        }
        // return true;
        // System.out.println("一致");
    }
}
