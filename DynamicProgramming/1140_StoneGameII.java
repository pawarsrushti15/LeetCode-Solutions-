/*
LeetCode: 1140
Problem: Stone Game II
Difficulty: Medium

Approach:
- Use Dynamic Programming with recursion and memoization.
- `dp[i][M]` represents the maximum number of stones the current
  player can collect starting from index `i` with the current value of M.
- Use a suffix sum array to quickly calculate the total stones
  remaining from index `i`.
- The current player can take X piles where 1 <= X <= 2 * M.
- After taking X piles, the new value of M becomes max(M, X).
- Instead of directly calculating the current player's score,
  calculate the opponent's maximum score and subtract it from
  the total remaining stones.
- If the player can take all remaining piles, return the suffix sum.

Time Complexity: O(n^3)
Space Complexity: O(n^2)
*/

class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum:
        // suffix[i] = total stones from i to n - 1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(piles, 0, 1);
    }

    private int solve(int[] piles, int i, int M) {

        // All piles are taken
        if (i >= piles.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int n = piles.length;

        // If we can take all remaining piles
        if (i + 2 * M >= n) {
            return dp[i][M] = suffix[i];
        }

        int maxStones = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            // Stones opponent can get
            int opponent = solve(piles, i + X, newM);

            // Current player's total
            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}
