package datastructures.slidingwindowpattern;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest
 * contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 */

/**
 * Time complexity is O(n) + O(n) = O(n)
 * Space complexity is O(1);
 */

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element.
            while (windowSum >= S) {
                minLength = Math.min(minLength,windowEnd - windowStart + 1 );
                windowSum -= arr[windowStart]; //subtract the element going out
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
    }

}
