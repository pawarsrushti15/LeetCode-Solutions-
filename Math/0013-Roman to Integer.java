
/*
LeetCode: 13
Problem: Roman to Integer
Difficulty: Easy

Approach:
- Traverse the Roman numeral string from left to right.
- Convert each Roman symbol into its corresponding integer value.
- If the current value is smaller than the next value, subtract it.
- Otherwise, add it to the result.
- This handles special cases such as IV, IX, XL, XC, CD, and CM.
- Use a helper method to return the value of each Roman symbol.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = value(s.charAt(i));

            // If current value is smaller than next value,
            // subtract it
            if (i + 1 < s.length() &&
                current < value(s.charAt(i + 1))) {

                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    private int value(char c) {

        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }
}
