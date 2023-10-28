package Leetcode.L202305;

/**
 * 力扣11
 * @author yangf073
 * @date 2023/5/5 22:58
 */
public class L0505_11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        // 双指针 左指针left 右指针right
        int left = 0;
        int right = height.length -1 ;
        int res  = 0;
        while (left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(res,area);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        System.out.println(res);
    }
}
