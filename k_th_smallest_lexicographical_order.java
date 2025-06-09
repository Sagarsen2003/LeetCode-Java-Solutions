class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;  // Because we're already at 1

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;      // Go to next sibling
                k -= steps;  // Skip over the whole subtree
            } else {
                curr *= 10;  // Go to first child
                k--;         // Count this step
            }
        }

        return curr;
    }

    private long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }
}
