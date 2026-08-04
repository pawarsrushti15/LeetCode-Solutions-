/*
LeetCode: 9
Problem: Palindrome Number
Difficulty: Easy

Approach:
- Convert the integer to a string.
- Use two pointers (left and right).
- Compare characters from both ends.
- If any pair doesn't match, return false.
- Otherwise, return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
