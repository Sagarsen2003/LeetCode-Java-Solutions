class Solution {
    public int mySqrt(int x) {

        // Declare a variable to store the square root result
        double output;

        // Use the built-in Math.sqrt() method to calculate square root of x
        output = Math.sqrt(x);

        // Return the integer part of the square root (truncate the decimal)
        return (int) output;
    }
}

