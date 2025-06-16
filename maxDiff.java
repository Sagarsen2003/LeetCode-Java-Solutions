class Solution {
    public int maximumDifference(int[] nums) {
        // Initialize the minimum value as the first element
        int minVal = nums[0];

        // maxDiff will hold the maximum difference found, start with -1 as default
        int maxDiff = -1;

        // Start from the second element since we already took the first as minVal
        for (int i = 1; i < nums.length; i++) {

            // If current number is greater than minVal, it can form a valid increasing pair
            if (nums[i] > minVal) {
                // Calculate the difference and update maxDiff if it's larger
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                // Otherwise, update minVal because we found a new minimum
                minVal = nums[i];
            }

        }

        // Return the maximum difference found, or -1 if no valid pair exists
        return maxDiff;
    }
}
