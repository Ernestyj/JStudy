package indeed;

import java.util.*;

/**
 * Created by eugene on 16/7/2.
 */
public class M4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] nums = new int[k];
        for (int i=0; i<nums.length; i++) nums[i] = sc.nextInt();
        int[] balls = generate(k, nums);
        //for (int b: balls) System.out.print(b+ " ");
        int sum = 0;
        for (int i=0; i<10000; i++){
            sum += sim(k, balls);
        }
        double res = (double)sum/10000;
        System.out.println(String.format("%.2f", res));
    }

    public static int[] generate(int k, int[] nums){
        int sum = 0, start = 0, color = 0;
        for (int n: nums) sum += n;
        int[] balls = new int[sum];
        for (int n: nums) {
            Arrays.fill(balls, start, start+n, color++);
            start += n;
        }
        return balls;
    }
    public static int sim(int k, int[] balls){
        Random r = new Random();
        int len = balls.length;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        while (set.size()!=k){
            int i = new Random().nextInt(len);
            set.add(balls[i]);
            count++;
        }
        return count;
    }


}
