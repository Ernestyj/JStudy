package algorithm;

/**
 * Created by DCLab on 11/3/2015.
 */
public class Sort {

    public static void main(String[] args) {

        int[] nums = {48, 6, 57, 42, 60, 72, 83, 73, 88, 85};
//        new Sort().quickSort(nums);
        int[] result = new Sort().mergeSort(nums);

        System.out.println("*****RESULT*****");
        for (int i : result) System.out.print(i + " ");
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

    /**
     * 分治模型在每一层递归上都有三个步骤：
        分解（Divide)：将原问题分解成一系列子问题。
        解决(Conquer)：递归的解各个子问题。若子问题足够小，则直接求解。
        合并(Combine)：将子问题的结果合并成原问题的解。
     *
     * 基本思路就是将数组分成二组A、B，如果A、B内的数据都是有序的，那么就可以方便的将这二组数据进行排序。
     * 可以将A，B组各自再分成二组，依次类推；
     * 当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序；（最底层排序）
     * 然后再合并相邻的二个小组就可以了。
     *
     * 时间复杂度：nlogn
     * 分析：设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，
     * 时间复杂度可以记为O(N)，故一共为O(N*logN)。
     *
     * @param nums
     * @return 排好序的数组
     */
    public int[] mergeSort(int[] nums){
        int[] tempSorted = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tempSorted);
        return tempSorted;
    }
    private void mergeSort(int[] unsorted, int left, int right, int[] tempSorted){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(unsorted, left, mid, tempSorted); //左边有序
            mergeSort(unsorted, mid + 1, right, tempSorted);    //右边有序
            merge(unsorted, left, mid, right, tempSorted);  //再将二个有序数列合并
        }
    }
    private void merge(int[] origin, int left, int mid, int right, int[] tempSorted){
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){ //真正排序的地方
            if (origin[i] < origin[j]) tempSorted[k++] = origin[i++];
            else tempSorted[k++] = origin[j++];
        }
        while (i <= mid) tempSorted[k++] = origin[i++];
        while (j <= right) tempSorted[k++] = origin[j++];
        //更新origin数组
        for (int x = 0; x < k; x++) origin[left + x] = tempSorted[x];
    }




}
