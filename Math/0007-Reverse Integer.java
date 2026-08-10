/*
LeetCode: 7
Problem: Reverse Integer
Difficulty: Medium

Approach:
- Store the input number in a long variable to safely handle the reversed value.
- Extract the last digit using n % 10.
- Remove the last digit using n / 10.
- Build the reversed number by multiplying rev by 10 and adding the last digit.
- After reversing, check whether the result is outside the 32-bit signed integer range.
- If it overflows, return 0.
- Otherwise, return the reversed number as an integer.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int reverse(int x) {

        long n = x;
        long rev = 0;

        while (n != 0) {

            long lastDigit = n % 10;

            n = n / 10;

            rev = (rev * 10) + lastDigit;
        }

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}
