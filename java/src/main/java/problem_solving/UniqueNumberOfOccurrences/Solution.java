package problem_solving.UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     *  LC1207 - https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
     *  Using HashMap to store value-occurrences
     *      If it already occurred then increase 1
     *  Using Set to store the occurrences
     *      If this set's size equal to the occurrences size, it means they are unique
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num: arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>(occurrences.values());
        return uniqueOccurrences.size() == occurrences.size();

         //Second way:
//         HashSet<Integer> uniqueCounts = new HashSet<>();
//         for (int count : occurrences.values()) {
//             if (!uniqueCounts.add(count)) { // If duplicated key, return false immediately
//                 return false;
//             }
//         }
//        return true;

    }
}
