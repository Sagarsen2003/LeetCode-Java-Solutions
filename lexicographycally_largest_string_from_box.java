class Solution {
    public String answerString(String word, int numFriends) {
        // Base case: If there's only 1 friend, return the entire word as-is
        if (numFriends == 1) {
            return word;
        }

        int len = word.length();

        // Calculate the largest possible substring length that can be formed
        // After dividing the word among 'numFriends' people, (numFriends - 1) cuts are made
        int largestPossibleLength = len - (numFriends - 1);

        // This will store the lexicographically largest valid substring found
        String result = "";

        // Loop through each index in the word to try forming valid substrings
        for (int i = 0; i < len; i++) {
            // We can only take a substring of size up to largestPossibleLength,
            // and we can't exceed the bounds of the string
            int minTakeLength = Math.min(largestPossibleLength, len - i);

            // Extract the substring starting at i with the allowable length
            String subString = word.substring(i, i + minTakeLength);

            // Compare with the current best result and update if this one is larger
            if (subString.compareTo(result) > 0) {
                result = subString;
            }
        }

        // Return the lexicographically largest substring found
        return result;
    }
}

