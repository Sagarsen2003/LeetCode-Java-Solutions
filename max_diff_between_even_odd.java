class Solution {
    public int maxDifference(String s) {
        int n = s.length();

        int maxOdd = 0;
        int minEven = n + 1;

        int[] freq = new int[26]; // for 'a' to 'z'

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            if (freq[i] % 2 == 0) {
                minEven = Math.min(minEven, freq[i]);
            } else {
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }

        return maxOdd - minEven;
    }
}