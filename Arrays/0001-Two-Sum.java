/*
LeetCode: 1
Problem: Two Sum
Difficulty: Easy

Approach:
- Use a HashMap to store previously seen numbers.
- Check whether the complement exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
