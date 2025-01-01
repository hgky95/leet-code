package problem_solving.FindTheDifferenceOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * 1. Create Set1 from nums1
     * 2. Create Set2 from nums2
     * 3. Loop on each element from Set1 and check if set2 contains it or not. If not contains, add to result list
     * 4. Loop on each element from Set2 and check if set1 contains it or not. If not contains, add to result list
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> answer1 = new ArrayList<>();
        List<Integer> answer2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                answer1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                answer2.add(num);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(answer1);
        answer.add(answer2);
        return answer;
    }

//    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//        for (int num : nums1) {
//            set1.add(num);
//        }
//        for (int num : nums2) {
//            set2.add(num);
//        }
//
////        Set<Integer> uniqueToNums1 = new HashSet<>(set1);
////        uniqueToNums1.removeAll(set2);
////
////        // Find elements unique to nums2
////        Set<Integer> uniqueToNums2 = new HashSet<>(set2);
////        uniqueToNums2.removeAll(set1);
////
////        List<List<Integer>> answer = new ArrayList<>();
////        answer.add(new ArrayList<>(uniqueToNums1));
////        answer.add(new ArrayList<>(uniqueToNums2));
//
//        List<Integer> answer1 = new ArrayList<>();
//        List<Integer> answer2 = new ArrayList<>();
//
//        for (int num : set1) {
//            if (!set2.contains(num)) {
//                answer1.add(num);
//            }
//        }
//
//        for (int num : set2) {
//            if (!set1.contains(num)) {
//                answer2.add(num);
//            }
//        }
//
//        List<List<Integer>> answer = new ArrayList<>();
//        answer.add(answer1);
//        answer.add(answer2);
//        return answer;
//    }
}
