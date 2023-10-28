package Leetcode.L20230320;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Category L20230320
 * @Description 【功能描述】
 * @Author kkk
 * @Since 2023/3/20 16:34
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 *
 * 所以返回 [0, 1]
 *
 */
public class L1 {
    public static void main(String[] args) {
        int[] res = new int[2];
        int[] nums = {2,7,11,15};
        int target = 9;
        if (nums == null || nums.length == 0) {
            // return res;
        }
        // hashMap key存储值，value存储该值对应数组的下标
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 得到需要匹配的值
            int temp = target - nums[i];
            // 去hashmap中寻找是否包含，包含则赋值res数组
            if (hashMap.containsKey(temp)) {
                res[0] = i;
                res[1] = hashMap.get(temp);
            }
            // 不包含则将值放入hashMap中
            hashMap.put(nums[i],i);
        }
        // return res;
        System.out.println(Arrays.toString(res));
    }
}
