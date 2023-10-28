package Leetcode.L20230320;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Category L20230320
 * @Description 【功能描述】
 * @Author kkk
 * @Since 2023/3/20 11:48
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class L349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {2,2};
        // 利用hashSet存储不重复元素的特性来做到保证唯一性
        // 将nums1数组的值装入hashSet中
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int num : nums1) {
            hashSet1.add(num);
        }
        // 遍历nums2，判断hashSet1中是否包含nums2中的值，如果包含，则加入hashSet2中
        for (int num : nums2) {
            if (hashSet1.contains(num)) {
                hashSet2.add(num);
            }
        }
        // 返回数组
        int[] res = new int[hashSet2.size()];
        int j = 0;
        for (int i : hashSet2) {
            res[j] = i;
            j ++;
        }
        System.out.println(Arrays.toString(res));

    }
}
