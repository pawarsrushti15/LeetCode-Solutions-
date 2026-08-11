/*
LeetCode: 2996
Problem: Smallest Missing Integer Greater Than Sequential Prefix Sum
Difficulty: Easy

Approach:
- Find the sum of the longest sequential prefix.
- A sequential prefix contains consecutive numbers where each number
  is exactly 1 greater than the previous number.
- Store all elements of the array in a HashSet for quick lookup.
- Starting from the sequential prefix sum, check whether the number
  exists in the array.
- If it exists, increment the number and continue.
- Return the first number that is missing from the array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // Step 1: Find sum of longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: Store all numbers in a HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Find smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
