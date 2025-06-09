class Solution {
    public int removeElement(int[] nums, int val) {
        // 'k' will track the position to overwrite with valid (non-val) elements
        int k = 0;  
        
        // Iterate through the entire array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value to be removed
            if (nums[i] != val) {
                nums[k] = nums[i]; // Overwrite the element at index k
                k++;  // Move to next position for valid element
            }
            // If nums[i] == val, we just skip it
        }
        
        // Return the count of elements not equal to 'val'
        return k;
    }
}

