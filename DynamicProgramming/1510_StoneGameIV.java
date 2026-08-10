/*
LeetCode: 1510
Problem: Stone Game IV
Difficulty: Medium

Approach:
- Use Dynamic Programming to determine whether the current player can win.
- dp[i] represents whether the current player can win when there are i stones.
- dp[0] is false because no stones are available, so the current player loses.
- For every number of stones i, try removing every possible perfect square.
- If there exists a square number j * j such that dp[i - j * j] is false,
  then the current player can make a winning move.
- Mark dp[i] as true and stop checking further squares.
- Finally, return dp[n].

Time Complexity: O(n * sqrt(n))
Space Complexity: O(n)
*/

class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        // dp[0] = false
        // No stones -> current player loses

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                int remaining = i - j * j;

                // If opponent is in a losing position,
                // current player wins.
                if (!dp[remaining]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
