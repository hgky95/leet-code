package problem_solving.FindTheHighestAltitude;

public class Solution {

    /**
     *  Create a new array 'altitudes' with length of gain + 1 because it always has the first item is 0
     *  Loop on 'gain' array and calculate the newAltitude by sum of current altitudes and new value
     *  Then compare with the newAltitude to figure out the highest Altitude
     */
    public int highestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        int highestAltitude = altitudes[0];

        for (int i = 0; i < gain.length; i++) {
            int newAltitude = altitudes[i] + gain[i];
            altitudes[i+1] = newAltitude;
            highestAltitude = Math.max(highestAltitude, newAltitude);
        }
        return highestAltitude;
    }
}
