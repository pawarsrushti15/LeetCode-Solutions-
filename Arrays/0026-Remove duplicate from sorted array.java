/*
LeetCode: 26
Problem: Remove Duplicates from Sorted Array
Difficulty: Easy

Approach:
- Use two pointers (i and j).
- Pointer i keeps track of the last unique element.
- Pointer j traverses the array.
- When a new unique element is found, increment i and place the new element at nums[i].
- Return i + 1 as the count of unique elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = 1;

        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }
}
