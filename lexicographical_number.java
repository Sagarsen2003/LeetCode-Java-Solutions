import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        // This list will store the final result in lexicographical order
        List<Integer> result = new ArrayList<>();

        // Start DFS from numbers 1 to 9 (you can't start from 0)
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result); // Begin DFS traversal from each digit
        }

        return result; // Return the fully populated result list
    }

    // Depth-First Search helper function
    private void dfs(int curr, int n, List<Integer> result) {
        // Base case: if current number exceeds n, stop recursion
        if (curr > n)
            return;

        // Add the current number to the result list
        result.add(curr);

        // Try appending digits 0 to 9 to current number (i.e., explore the tree deeper)
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i; // Form next number (e.g., 1 → 10 → 100, etc.)

            // If the next number exceeds n, stop exploring further
            if (next > n)
                break;

            // Recursively call dfs with the next number
            dfs(next, n, result);
        }
    }
}
