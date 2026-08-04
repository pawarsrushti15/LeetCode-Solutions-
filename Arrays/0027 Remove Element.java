/*
LeetCode: 27
Problem: Remove Element
Difficulty: Easy

Approach:
- Use two pointers (i and j).
- Pointer i keeps track of the position where the next valid element should be placed.
- Pointer j traverses the entire array.
- If nums[j] is not equal to val, place nums[j] at nums[i] and increment i.
- Return i as the count of elements remaining after removing val.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }

        }

        return i;
    }
}
