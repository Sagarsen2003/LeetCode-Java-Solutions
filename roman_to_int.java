import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map to store the integer value of each Roman numeral
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        // Step 2: Initialize result to accumulate the final value
        int result = 0;  
        
        // Step 3: Traverse each character in the input string
        for (int i = 0; i < s.length(); i++) {
            int currentVal = romanValues.get(s.charAt(i)); // Value of current Roman numeral
            
            // Step 4: Check if current value is less than the next value
            // This handles subtractive notation like IV = 4, IX = 9, etc.
            if (i < s.length() - 1 && currentVal < romanValues.get(s.charAt(i + 1))) {
                result -= currentVal;  // Subtract if a smaller value precedes a larger one
            } else {
                result += currentVal;  // Otherwise, add the value normally
            }
        }
        
        // Step 5: Return the final computed integer value
        return result;  
    }
}
