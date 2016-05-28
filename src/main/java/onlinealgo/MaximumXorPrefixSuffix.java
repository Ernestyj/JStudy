package onlinealgo;

import java.util.Random;

/**
 * Created by eugene on 16/5/27.
 */
public class MaximumXorPrefixSuffix {

    static class Node {
        Node zero;
        Node one;
        public Node(){}
    }
    static class Trie {
        Node root;
        public Trie(){
            root = new Node();
        }
        public void add(int x) {
            Node p = root;
            for (int i=31; i>=0; i--) {
                int bit = (x>>i) & 1;   //get bit of x from low to high(0 to 31)
                if (bit==1) {
                    if (p.one==null) p.one = new Node();
                    p = p.one;
                } else {
                    if (p.zero==null) p.zero = new Node();
                    p = p.zero;
                }
            }
        }
        public int getXorOf(int x) {
            Node p = root;
            int res = 0;
            for (int i=31; i >= 0; i--) {
                int bit = (x>>i) & 1; //get bit of x from low to high(0 to 31)
                if (bit==1) {
                    if (p.zero!=null) {
                        p = p.zero;
                    } else {
                        res |= (1<<i);  //set the (i+1)th bit of res to 1
                        p = p.one;
                    }
                } else {
                    if (p.one!=null) {
                        res |= (1<<i);  //set the (i+1)th bit of res to 1
                        p = p.one;
                    } else {
                        p = p.zero;
                    }
                }
            }
            return res;
        }
    }

    /**
     * f(l,r) is the xor of array sequence from index l to r.
     Property: f(l,r) = f(0,r)^f(0,l-1)
     if the max subarray end at index i, then maximize f(l,i)=f(0,i)^f(0,l-1),l<=i,
     suppose f(0,l-1) for all l<=i is inserted in trie.
     Method: from start to end, insert allXor into trie;
             from end to start, getXorOf(allXor)^allXor, find maximum.
     * @param nums
     * @return
     */
    public static int findMaxXorInPreAndSuffix(int[] nums) {
        Trie trie = new Trie();
        trie.add(0);
        int max = 0;
        int allXor = 0;
        for (int i=0; i<nums.length; i++) {
            allXor ^= nums[i];
            trie.add(allXor);
        }
        allXor = 0;
        for (int i=nums.length-1; i>=0; i--) {  //iterate from end to start
            allXor ^= nums[i];
            max = Math.max(max, allXor^trie.getXorOf(allXor));
        }
        return max;
    }


    /**
     * f(l,r) is the xor of array sequence from index l to r.
     Property: f(l,r) = f(0,r)^f(0,l-1)
     if the max subarray end at index i, then maximize f(l,i)=f(0,i)^f(0,l-1),l<=i,
     suppose f(0,l-1) for all l<=i is inserted in trie.
     * @param nums
     * @return
     */
    public static int findMaxXorInSubArray(int[] nums) {
        Trie trie = new Trie();
        trie.add(0);    //add 0 in advance, so the number can be compared to itself left
        int max = 0;
        int allXor = 0;
        for (int i=0; i<nums.length; i++) {
            allXor ^= nums[i];
            max = Math.max(max, allXor^trie.getXorOf(allXor));
            trie.add(allXor);
        }
        return max;
    }

    public static int findMaxBruteForce(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int m = 0;
            for (int j = i; j < array.length; j++) {
                m ^= array[j];
                max = Math.max(max, m);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 50;
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100000) + 1;
        }

//        int[] nums = {2,5,3,7,7,7,0,5,3,8,2,6,4};
        int[] nums = {1000,1000};
        int x = findMaxXorInPreAndSuffix(nums);
        System.out.println(x);

//        int a = findMaxBruteForce(array);
//        int b = findMaxXorInSubArray(array);
//
//        if (a == b) {
//            System.out.println("Algorithm success!");
//            System.out.println(String.format("----> %d == %d", a, b));
//        } else {
//            System.out.println("Algorithm failed!");
//            System.out.println(String.format("----> %d != %d", a, b));
//        }
    }


}
