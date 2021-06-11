package datastructures.slidingwindowpattern;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of characters where each character represents a fruit tree, you are given two baskets,
 * and your goal is to put maximum number of fruits in each basket.The only restriction is that each basket
 * can have only one type of fruit.
 *
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from
 * each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both baskets.
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 *
 */

public class MaxFruitCountOf2Types {
    public static int findMaxNum(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character,Integer> fruitFequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightFruit = arr[windowEnd];
            fruitFequencyMap.put(rightFruit ,fruitFequencyMap.getOrDefault(rightFruit,0)+1);
            while (fruitFequencyMap.size() > 2) {
                char leftFruit = arr[windowStart];
                fruitFequencyMap.put(leftFruit,fruitFequencyMap.get(leftFruit)-1);
                if (fruitFequencyMap.get(leftFruit) == 0) {
                    fruitFequencyMap.remove(leftFruit);
                }
                windowStart++; //Shrink the window.
            }
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result = findMaxNum(new char[] {'A', 'B', 'C', 'B', 'B', 'C'});
        int result1 = findMaxNum(new char[] {'A', 'B', 'C', 'A', 'C'});
        System.out.println("The maximum number of fruits that can be collected in two baskets are : "+ result);
        System.out.println("The maximum number of fruits that can be collected in two baskets are : "+ result1);
    }
}
