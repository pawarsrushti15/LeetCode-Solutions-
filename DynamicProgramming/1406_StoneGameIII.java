/*
LeetCode: 1406
Problem: Stone Game III
Difficulty: Hard

Approach:
- Use Dynamic Programming to calculate the maximum score difference
  the current player can achieve over the opponent.
- dp[i] represents the maximum score difference the current player
  can achieve starting from index i.
- Traverse the array from right to left.
- At each position, the current player can take 1, 2, or 3 stones.
- Keep a running sum of the stones taken.
- For each possible move:
    current score difference = sum - dp[i + k + 1]
- Choose the move that gives the maximum score difference.
- Finally:
    dp[0] > 0  -> Alice wins
    dp[0] < 0  -> Bob wins
    dp[0] == 0 -> Tie

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = Integer.MIN_VALUE;
            int sum = 0;

            // Current player can take 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {

                sum += stoneValue[i + k];

                dp[i] = Math.max(
                    dp[i],
                    sum - dp[i + k + 1]
                );
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
