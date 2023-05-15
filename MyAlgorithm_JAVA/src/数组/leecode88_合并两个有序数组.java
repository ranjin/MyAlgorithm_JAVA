package 数组;
/**
 * 两个排序数组 num1和nums2。m与n分别表示nums1与nums2中的元素数目
 * 合并nums2到nums1中
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
class Solution {
    /**
     * 思路：
     * 由于是需要将nums2的数组合并到nums1中
     * 将双指针初始化在数组尾部，然后从后往前进行合并。
     * 这样避免从头往后会覆盖num1中的元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 两个指针分别初始化在两个数组的最后一个元素
        int i = m - 1; 
        int j = n - 1;
        // 生成排序的结果
        int p = nums1.length - 1;
        // 从后往前生成结果数组，类似合并两个有序链表的逻辑
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
        // 可能其中一个数组的指针走到尽头了。
        // 这里我们只需要考虑nums2是否剩元素即可。
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}