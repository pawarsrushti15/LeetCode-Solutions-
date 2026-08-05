/*
LeetCode: 69
Problem: Sqrt(x)
Difficulty: Easy

Approach:
- Use Binary Search to find the integer square root.
- Handle the edge cases where x is 0 or 1.
- Search in the range [1, x].
- Calculate mid and compare mid * mid with x.
- If mid * mid equals x, return mid.
- If mid * mid is less than x, store mid as the current answer and search the right half.
- Otherwise, search the left half.
- Use long while calculating mid * mid to prevent integer overflow.
- Return the stored answer, which is the floor value of the square root.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
