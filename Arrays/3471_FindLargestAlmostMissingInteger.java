/*
LeetCode: 3471
Problem: Find the Largest Almost Missing Integer
Difficulty: Easy

Approach:
- Check every subarray of size k using a sliding window.
- Use a HashSet for each window to store only distinct elements.
- Count how many different windows contain each element.
- An element is "almost missing" if it appears in exactly one
  subarray of size k.
- Traverse the frequency map and find the largest element whose
  window count is exactly 1.
- If no such element exists, return -1.

Time Complexity: O(n * k)
Space Complexity: O(n + k)
*/

import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        // Check every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Store distinct elements of current window
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count this window for each distinct element
            for (int x : set) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        // Find largest element appearing in exactly one window
        int answer = -1;

        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                answer = Math.max(answer, x);
            }
        }

        return answer;
    }
}
