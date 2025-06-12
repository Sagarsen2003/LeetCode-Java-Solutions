import java.util.*;

class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length(); // Length of the input string
        int ans = Integer.MIN_VALUE; // Initialize answer to smallest integer as a starting point

        // Iterate over all possible pairs of characters a and b from '0' to '4'
        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) // Skip if both characters are the same (we want distinct pairs)
                    continue;

                int[] best = new int[4]; // Array to track minimum differences for each status combination
                Arrays.fill(best, Integer.MAX_VALUE); // Initialize all values to max integer

                int cntA = 0, cntB = 0; // Counters for occurrences of characters a and b in current window
                int prevA = 0, prevB = 0; // Counters for occurrences of a and b in the left part (prefix)
                int left = -1; // Left pointer of sliding window, starts before beginning of string

                // Sliding window right pointer moving through the string
                for (int right = 0; right < n; right++) {
                    // Update counts of a and b for the current character at right pointer
                    if (s.charAt(right) == a)
                        cntA++;
                    if (s.charAt(right) == b)
                        cntB++;

                    // Shrink the window from the left if window size reaches at least k and
                    // the difference in count of b between current and previous prefix is >= 2
                    while (right - left >= k && (cntB - prevB) >= 2) {
                        int leftStatus = getStatus(prevA, prevB); // Get parity status of prefix counts

                        // Update the best array with minimum difference for this status
                        best[leftStatus] = Math.min(best[leftStatus], prevA - prevB);

                        left++; // Move left pointer forward to shrink window

                        // Adjust prefix counts as left pointer moves
                        if (left < n && s.charAt(left) == a)
                            prevA++;
                        if (left < n && s.charAt(left) == b)
                            prevB++;
                    }

                    int rightStatus = getStatus(cntA, cntB); // Get parity status for current counts
                    int targetStatus = rightStatus ^ 0b10; // Flip the first bit to get target status

                    // If we have a previously recorded best value for the targetStatus,
                    // calculate and update the maximum difference found so far
                    if (best[targetStatus] != Integer.MAX_VALUE) {
                        ans = Math.max(ans, (cntA - cntB) - best[targetStatus]);
                    }
                }
            }
        }

        // If ans was never updated, return -1, else return the maximum difference found
        return (ans == Integer.MIN_VALUE ? -1 : ans);
    }

    // Helper method to get a 2-bit parity status for counts of a and b
    // Left bit: parity of cntA, Right bit: parity of cntB
    private int getStatus(int cntA, int cntB) {
        return ((cntA % 2) << 1) | (cntB % 2);
    }
}
