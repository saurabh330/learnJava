package datastructures.slidingwindowpattern;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, find the length of the longest substring, which has no repeating characters.
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */

public class NoRepeatingSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character,Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++ ) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) +1);
            }
            charIndexMap.put(rightChar,windowEnd);// insert the 'rightChar' into the map
            maxLength = Math.max(maxLength,windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result = findLength("abbbb");
        System.out.println("Length of longest substring without repeating character is : " + result);
    }
}
