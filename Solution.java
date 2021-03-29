import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Sum two numbers
 */
class Solution {


    /**
     * Given an array of integers, return indices of the two numbers 
     * such that they add up to a specific target.
     * 
     * You may assume that each input would have exactly one solution, 
     * and you may not use the same element twice.
     * 
     * Runtime: 0 ms
     * Memory Usage: 38.9 MB
     */
    static int[] sumOfTwo1(int[] nums, int target) {

        // **** initialization ****
        int[] result = new int[2];

        // **** generate a hashmap of values and indices O(n) ****
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            // **** generate the complement ****
            int complement = target - nums[i];

            // **** check if complement in the hasmap ****
            if (hm.containsKey(complement)) {
                result[0] = i;
                result[1] = hm.get(complement);
                return result;
            }

            // **** add value to hash map ****
            hm.putIfAbsent(nums[i], i);
        }

        // **** instead of returning [0, 0] ****
        throw new IllegalArgumentException("No two sum solution");
    }



    /**
     * Given an array of integers, return indices of the two numbers 
     * such that they add up to a specific target.
     * 
     * You may assume that each input would have exactly one solution, 
     * and you may not use the same element twice.
     * 
     * Runtime: 0 ms
     * Memory Usage: 39.3 MB
     */
    static int[] sumOfTwo(int[] nums, int target) {

        // **** traverse array O(n) ****
        for (int i = 0; i < nums.length - 1; i++) {

            // **** traverse array O(n) ****
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        // **** did not find solution ****
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * Test scafolding.
     */
    public static void main(String[] args) {

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read the number of integers in the array ****
        int n = sc.nextInt();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** allocate array of integers ****
        int[] arr = new int[n];

        // **** populate the array ****
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // **** read the target ****
        int target = sc.nextInt();

        // ???? ????
        System.out.println("main <<< target: " + target);

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** generate result (if possible) ****
        int[] result = sumOfTwo1(arr, target);

        // **** display result ****
        System.out.println(Arrays.toString(result));

        // **** generate result (if possible) ****
        result = sumOfTwo(arr, target);

        // **** display result ****
        System.out.println(Arrays.toString(result));
    }
}