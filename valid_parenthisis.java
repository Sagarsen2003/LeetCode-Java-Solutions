class Solution {
    public boolean isValid(String s) {

        // Checks For the parenthisis () , [] and {}
  while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }

        return s.isEmpty();
}
}
