class Solution {

    public int removeDuplicates(int[] nums) {
        // Edge case: If array is empty, return 0
        if (nums.length == 0) return 0;

        // This index will track the position of the last unique element found
        int uniqueIndex = 0;

        // Start iterating from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current number is different from the last unique one
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++; // Move to the next position for a unique number
                nums[uniqueIndex] = nums[i]; // Place the new unique number
            }
        }

        // Return the count of unique elements, which is index + 1
        return uniqueIndex + 1;
    }
}


