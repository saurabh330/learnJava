package datastructures.slidingwindowpattern;

/**
 *
 *[Leet Code Questions]
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int windowStart = 0;
        int subStringLength = 0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0)+1);
            while (charFrequencyMap.get(rightChar) > 1) {
                char leftChar = s.charAt(windowStart);
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
                windowStart++;
            }
            subStringLength = Math.max(subStringLength, windowEnd - windowStart+1);
        }
        return subStringLength;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabcbb");
        int result1 = lengthOfLongestSubstring("bbbbb");
        System.out.println("Length of longest substring without repeating Characters is: "+ result);
        System.out.println("Length of longest substring without repeating Characters is: "+ result1);
    }

}


