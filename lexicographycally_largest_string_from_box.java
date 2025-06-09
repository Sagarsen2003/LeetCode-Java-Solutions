class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int len = word.length();
        int largestPossibleLength = len - (numFriends - 1);
        String result = "";

        for (int i = 0; i < len; i++) {
            int minTakeLength = Math.min(largestPossibleLength, len - i);
            String subString = word.substring(i, i + minTakeLength);

            if (subString.compareTo(result) > 0) {
                result = subString;
            }
        }

        return result;
    }
}