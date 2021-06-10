package datastructures.slidingwindowpattern;

import java.util.*;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * You can assume that K is less than or equal to the length of the given string.
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 *
 */

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }
        int windowStart = 0;
        int maxLength = 0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0)+1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
                if ( charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; //shrink the window
            }
            maxLength = Math.max(maxLength,windowEnd - windowStart + 1); // max length so far
        }
        return maxLength;
    }

    public static void main (String[] args){
        int result = findLength("araaci",2);
        int result1 = findLength("cbbebi",3);
        System.out.println("Longest Substring Length is : "+ result );
        System.out.println("Longest Substring Length is : "+ result1 );
    }
}
