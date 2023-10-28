package Leetcode.L20230320;

import java.util.HashSet;

/**
 * @Category L20230320
 * @Description 【功能描述】
 * @Author kkk
 * @Since 2023/3/20 14:42
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1 + 81 = 82
 * 64 + 4 = 68
 * 36 + 64 = 100
 * 1 + 0 + 0 = 1
 *
 * 输入：n = 2
 * 输出：false
 */
public class L202 {
    public static void main(String[] args) {
        int number = 2;
        HashSet<Integer> records = new HashSet<>();
        // number不为1，进行快乐数拆解,如果仅是如此，一直不为1会陷入死循环
        // 找到重复的，则代表陷入死循环，也就是不会为1，此时让它跳出
        while (number != 1 && !records.contains(number)) {
            records.add(number);
            number = split(number);
        }
        if (number == 1) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

    private static int split(int number) {
        int sum = 0;
        while (number > 0) {
            int temp = number % 10;
            sum = temp * temp + sum;
            number = number / 10;
        }
        return sum;
    }
}
