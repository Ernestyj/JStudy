package leetcode341_350;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**Given two arrays, write a function to compute their intersection.
 Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 Note: Each element in the result must be unique.
 The result can be in any order.
 * Created by eugene on 16/6/22.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> same = new HashSet<>();
        for (int i: nums1) set.add(i);
        for (int i: nums2)
            if (set.contains(i)) same.add(i);
        int[] res = new int[same.size()];
        int k = 0;
        for (int i: same) res[k++] = i;
        return res;
    }

}
