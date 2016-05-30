package algorithm;

/**
 * Created by DCLab on 11/3/2015.
 */
public class Sort {

    public static void main(String[] args) {

        int[] nums = {48, 6, 57, 42, 60, 72, 83, 73, 88, 85};
        System.out.println("*****RESULT*****");
//        new Sort().quickSort(nums);
//        for (int i : nums) System.out.print(i + " ");
        QuickSort.quickSort(nums, 0, nums.length-1);
        for (int i : nums) System.out.print(i + " ");

//        int[] result = new Sort().mergeSort(nums);
//        for (int i : result) System.out.print(i + " ");
    }

    /**TODO 重温加强理解
     * 快速排序（分治法） 时间复杂度：nlogn（最坏：n^2） 空间复杂度：nlogn 稳定性：不稳定
     * 基本思想是：
     1．先从数列中取出一个数（很多算法实现取最左边的数）作为基准数pivot。
     2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     3．再对左右区间重复第二步，直到各区间只有一个数。
     *
     * @param nums
     * @return
     */
    public int[] quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right){
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }
    private int partition(int nums[], int l, int r){
        int pivot = nums[l]; //枢轴记录
        while (l < r){
            while (l<r && nums[r]>=pivot) r--;
            nums[l] = nums[r];   //交换比枢轴小的记录到左端
            while (l<r && nums[l]<=pivot) l++;
            nums[r] = nums[l];   //交换比枢轴小的记录到右端
        }
        nums[l] = pivot; //扫描完成，枢轴到位
        return l;    //返回枢轴的位置
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
        return nums;    //或return tempSorted; 最终两个数组都是排好序的
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


    /**
     * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums){
        for (int i=1; i<nums.length; i++){
            if (nums[i-1]>nums[i]){
                int temp = nums[i];
                int j = i;
                while (j>0 && nums[j-1]>temp) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
            }
        }
        return nums;
    }

}

class QuickSort {
    //http://www.algolist.net/Algorithms/Sorting/Quicksort
    static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left+right)/2];
        while (i<=j) {
            while (arr[i]<pivot) i++;
            while (arr[j]>pivot) j--;
            if (i<=j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        };
        // 最后退出的情况应该是右指针在左指针左边一格
        return i;
    }
    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index-1) quickSort(arr, left, index - 1);  //TODO 注意边界
        if (index < right) quickSort(arr, index, right);
    }

    //合并版
    public static void quickSort1(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;    // pick the pivot
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {    // make left < pivot and right > pivot
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // 最后退出的情况应该是右指针在左指针左边一格
        // recursively sort two sub parts
        if (low < j) quickSort1(arr, low, j);
        if (high > i) quickSort1(arr, i, high);
    }
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
