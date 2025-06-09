import java.util.Stack; // Stack is used to simulate the robot's hand (t stack)

public class Solution {
    public String robotWithString(String s) {
        int n = s.length(); // Get length of the input string

        // minRight[i] will store the smallest character from s[i] to s[n-1]
        char[] minRight = new char[n];

        // Initialize the last element of minRight to the last char in the string
        minRight[n - 1] = s.charAt(n - 1);

        // Fill minRight array by traversing from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Take the smaller of the current character and the one to its right
            minRight[i] = (char) Math.min(s.charAt(i), minRight[i + 1]);
        }

        // This stack represents the robot's hand - characters are pushed here first
        Stack<Character> t = new Stack<>();

        // This StringBuilder acts like the final paper where characters are written
        StringBuilder paper = new StringBuilder();

        // Go through each character in the string
        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i)); // Push current character into the robot's hand (stack)

            // Try to write characters from the stack to the paper
            while (!t.isEmpty()) {
                char top = t.pop(); // Peek the top character from stack

                // If this is the last character OR it's <= the smallest remaining character in the rest of the string
                if (i == n - 1 || top <= minRight[i + 1]) {
                    paper.append(top); // Write it to the paper
                } else {
                    t.push(top); // Put it back if it’s not the time yet
                    break; // Stop writing; wait for a better opportunity
                }
            }
        }

        // Return the final result written on the paper
        return paper.toString();
    }
}
