import java.util.*; // Importing the utility package for List, Set, HashSet, etc.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // Convert the word dictionary into a HashSet for O(1) lookup time
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create a DP array where dp[i] means: can the string up to index i be segmented?
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // Empty string is always "breakable"

        // Loop through the string
        for (int i = 1; i <= s.length(); i++) {
            // Try breaking the string at every possible index j
            for (int j = 0; j < i; j++) {
                // If the substring from 0 to j is breakable AND substring from j to i is in dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;  // Mark current index as breakable
                    break; // No need to check further, found a valid break
                }
            }
        }

        // Return whether the full string can be segmented
        return dp[s.length()];
    }
}

