package datastructures.slidingwindowpattern;

/***
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */

public class MaximumSumSubarray {
    public static double findMaxSum(int[] arr, int K) {
        int windowStart = 0;
        double windowSum = 0;
        double maxSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd>=K-1) {
                maxSum = Math.max(maxSum,windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        double result1 = findMaxSum(new int[] {2, 1, 5, 1, 3, 2}, 3 );
        System.out.println("Maximum Sum of Subarrays in the given array is :"+result1);
        double result2 = findMaxSum(new int[] {2, 3, 4, 1, 5}, 2 );
        System.out.println("Maximum Sum of Subarrays in the given array is :"+result2);
    }
}
