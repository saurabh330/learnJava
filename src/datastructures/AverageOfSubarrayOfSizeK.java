/***
 * First Pattern in "Grokking the Coding Interview: https://www.educative.io/courses/grokking-the-coding-interview/7D5NNZWQ8Wr"
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */

package datastructures;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int K, int[] arr) {
        /***
         * Complexity of the below solution: O(n*K)
         */

//        double[] result = new double[arr.length - K + 1];
//        for (int i = 0; i <= arr.length - K; i++) {
//            //get the sum
//            double sum = 0;
//            for (int j = i; j < i + K; j++) {
//                sum += arr[j];
//            }
//            result[i] = sum / K; //calculate average
//        }
//        return result;

        /***
         * Complexity: O(n)
         */
        int windowStart = 0;
        double windowSum = 0;
        double[] result = new double[arr.length -K +1];
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            /*** Add the elements of the Array till Kth element ***/
            windowSum += arr[windowEnd];
            if (windowEnd >= K-1) {
                /*** If we reached the Kth element, add the windowSum value as first element in the result array ***/
                result[windowStart] += windowSum;
                /*** Remove the first element and increase the position for windowStart element. ***/
                windowSum -= windowStart;
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double result [] = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Average of subarrays of size K is: "+ Arrays.toString(result));

    }
}
