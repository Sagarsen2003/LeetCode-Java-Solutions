class Solution {
    public int minMaxDifference(int num) {

        // Convert the number to a string to easily access and manipulate digits
        String s = String.valueOf(num);

        // ======= MAX VALUE CALCULATION =======
        // We will replace the first non-9 digit with 9 to maximize the number
        char maxTarget = ' ';

        // Find the first digit that is NOT '9'
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxTarget = c;
                break;
            }
        }

        // If all digits are '9', no replacement needed. Else, replace target with '9'
        String maxStr = (maxTarget == ' ') ? s : s.replace(maxTarget, '9');

        // ======= MIN VALUE CALCULATION =======
        // We will replace the first digit with '0' to minimize the number
        char minTarget = s.charAt(0);
        String minStr = s.replace(minTarget, '0');

        // Parse both max and min strings back to integers
        int maxValue = Integer.parseInt(maxStr);
        int minValue = Integer.parseInt(minStr);

        // Return the difference between the max and min values
        return maxValue - minValue;
    }
}
