package indeed;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by eugene on 16/7/2.
 */
public class M2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        nums[0] = 0;
        for (int i=1; i<=n; i++){
            nums[i] = sc.nextInt();
        }
        //int[] nums = new int[]{0, 2, 4, 5, 1, 3};
        int res = cycle(n, nums);
        System.out.println(res);
    }

    public static int cycle(int n, int[] nums){
        HashSet<Integer> set = new HashSet<>(), used = new HashSet<>();
        int cycle = 0;
        for(int i=1; i<=n; i++) {
            int k = nums[i];
            if (used.contains(k)) continue;
            if (!set.contains(k)) {
                set.add(k); used.add(k);
                LinkedList<Integer> q = new LinkedList<>();
                q.offer(k);
                while (!q.isEmpty()) {
                    int index = q.poll();
                    if (set.add(nums[index])) {
                        used.add(nums[index]);
                        q.offer(nums[index]);
                    }else {
                        cycle++;
                        set.clear();
                        break;
                    }
                }
            }
        }
        return cycle;
    }

}
