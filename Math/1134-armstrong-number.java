/*
Problem: Armstrong Number
Difficulty: Easy

Approach:
- Store the original number in a duplicate variable.
- Count the number of digits in the given number.
- Extract each digit using num % 10.
- Raise each digit to the power of the total number of digits.
- Add the powered values to sum.
- Remove the last digit using num / 10.
- Finally, compare the calculated sum with the original number.
- If both are equal, the number is an Armstrong number.

Time Complexity: O(d)
Space Complexity: O(1)

where d is the number of digits in the number.
*/

import java.util.*;

public class Solution {

    public static boolean isArmstrong(int num) {

        int dup = num;
        int sum = 0;

        int digit = String.valueOf(num).length();

        while (num > 0) {

            int lastDigit = num % 10;

            sum = sum + (int) Math.pow(lastDigit, digit);

            num = num / 10;
        }

        return sum == dup;
    }
}
