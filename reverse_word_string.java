class Solution {
    public String reverseWords(String s) {

        // Step 1: Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Step 2: Split the trimmed string into words using regex for one or more spaces
        // "\\s+" ensures that multiple spaces are treated as one
        String[] words = s.split("\\s+");

        // Step 3: Use StringBuilder to build the reversed string efficiently
        StringBuilder reversed = new StringBuilder();
     
        // Step 4: Traverse the words array in reverse order and append to StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);

            // Add space after each word except the last one
            if (i > 0) {
                reversed.append(" ");
            }
        }

        // Step 5: Return the final reversed sentence
        return reversed.toString();
    }
}

