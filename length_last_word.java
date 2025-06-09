class Solution {
    public int lengthOfLastWord(String s) {
        // Remove any leading and trailing spaces from the string
        s = s.trim();

        // Find the index of the last space character in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(" ");

        // The length of the last word is the difference between the string's length
        // and the index of the last space, minus 1 (to exclude the space itself)
        return s.length() - lastSpaceIndex - 1;
    }
}

