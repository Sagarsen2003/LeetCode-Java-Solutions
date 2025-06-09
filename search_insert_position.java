class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;                 // Start pointer at the beginning of the array
        int right = nums.length - 1; // End pointer at the last index
        
        // Classic binary search loop: narrow down until left passes right
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate middle index, avoid overflow
            
            if (nums[mid] == target) {  // Found target, return its index immediately
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;         // Target is bigger, search right half
            } else {
                right = mid - 1;        // Target is smaller, search left half
            }
        }
        
        // If target not found, left will be the correct insert position
        return left;
    }
}

