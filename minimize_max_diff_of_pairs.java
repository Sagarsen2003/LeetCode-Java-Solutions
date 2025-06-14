import java.util.Arrays;

class Solution {
    int n; // Will store the length of the input array

    // Helper function to check if it's possible to form at least 'p' pairs
    // such that the difference between each pair is <= 'mid'
    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int pairs = 0;

        // Traverse the array greedily to form valid adjacent pairs
        while (i < n - 1) {
            // If the difference between current and next element is <= mid, we make a pair
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++; // Found a valid pair
                i += 2; // Skip the next element since it’s already paired
            } else {
                i++; // Move to the next element to try again
            }
        }

        // Return true if we formed at least 'p' valid pairs
        return pairs >= p;
    }

    // Main function to find the minimum possible "maximum" difference
    public int minimizeMax(int[] nums, int p) {
        n = nums.length;

        // Step 1: Sort the array to make adjacent pairs meaningful
        Arrays.sort(nums);

        // Step 2: Set up binary search boundaries
        int left = 0; // Minimum possible difference
        int right = nums[n - 1] - nums[0]; // Maximum possible difference
        int result = Integer.MAX_VALUE; // Store the minimum of all valid mids

        // Step 3: Binary search on the possible maximum differences
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If it's possible to form 'p' pairs with max difference <= mid
            if (isValid(nums, mid, p)) {
                result = mid; // Update result with the smaller valid mid
                right = mid - 1; // Try to find an even smaller valid mid
            } else {
                left = mid + 1; // Need to increase the allowed difference
            }
        }

        // Final answer: smallest maximum difference that allows forming 'p' pairs
        return result;
    }
}
