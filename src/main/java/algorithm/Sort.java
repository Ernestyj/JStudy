package algorithm;

/**
 * Created by DCLab on 11/3/2015.
 */
public class Sort {

    public static void main(String[] args) {

        int[] nums = {48, 6, 57, 42, 60, 72, 83, 73, 88, 85};
        new Sort().quickSort(nums);

        System.out.println("*****RESULT*****");
        for (int i : nums) System.out.print(i + " ");
    }

    /**
     * 快速排序（挖坑填数+分治法） 时间复杂度：nlogn（最坏：n^2） 空间复杂度：nlogn 稳定性：不稳定
     * 基本思想是：TODO 边画图边写代码，边界值极易错
     1．先从数列中取出一个数（这里取中间数，很多算法实现取最左边的数）作为基准数pivot。
     2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * @param nums
     * @return
     */
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        return;
    }
    private void quickSort(int[] nums, int left, int right){
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }
    /**
     * ex. {58, 6, 57, 42, 60}
     *      si      p
     *     {6, 58, 57, 42, 60}
     *      s   i   p
     *          s   pi
     *     {6, 42, 57, 58, 60}
     *          s   p   i
     *             ps       i
     *     新一轮for循环：
     *     {42, 6, 57, 58, 60}
     *       i     sp
     */
    private int partition(int nums[], int left, int right){
        int pivotIndex = (left + right) / 2;
        int storeIndex = left;
        for (int i = left; i < right; i++){
            if (nums[i] < nums[pivotIndex]){
                swap(nums, i, storeIndex);
                storeIndex++;   // 交换后storeIndex自增1，代表下一个可能要交换的位置
            }
        }
        swap(nums, storeIndex, pivotIndex);
        return storeIndex;
    }
    private void swap(int[] nums, int i, int j){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }



}
