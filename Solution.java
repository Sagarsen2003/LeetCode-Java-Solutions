import java.util.Stack;

public class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minRight = new char[n];

        minRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = (char) Math.min(s.charAt(i), minRight[i + 1]);
        }

        Stack<Character> t = new Stack<>();
        StringBuilder paper = new StringBuilder();

        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i));

            while (!t.isEmpty()) {
                char top = t.pop();

                if (i == n - 1 || top <= minRight[i + 1]) {
                    paper.append(top);
                } else {
                    t.push(top);
                    break;
                }
            }
        }

        return paper.toString();
    }
}