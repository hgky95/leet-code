import java.util.*;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        ContainsDuplicate217 instance = new ContainsDuplicate217();
        int[] nums = new int[]{1,2,3,4, 1};
        System.out.println("Duplicated is " + instance.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> targetSet = new HashSet<>();
        for (int number : nums) {
            if (targetSet.contains(number)) {
                return true;
            }
            targetSet.add(number);
        }
        return false;
    }
}
