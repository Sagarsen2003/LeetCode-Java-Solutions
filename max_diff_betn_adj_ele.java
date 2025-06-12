class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length; // Get the length of the array

        int maxDifference = 0; // Initialize maxDifference to track the highest adjacent difference found

        // Loop through every element in the array
        for (int i = 0; i < n; i++) {
            // Calculate the index of the next element in a circular manner
            // (i + 1) % n ensures when i is the last index, nextIndex wraps back to 0
            int nextIndex = (i + 1) % n;

            // Compute the absolute difference between current element and the next element
            int difference = Math.abs(nums[i] - nums[nextIndex]);

            // Update maxDifference if the current difference is greater
            maxDifference = Math.max(maxDifference, difference);
        }

        // Return the maximum absolute difference between adjacent elements
        return maxDifference;
    }
}
