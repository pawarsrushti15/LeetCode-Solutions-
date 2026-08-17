/*
LeetCode: 1563
Problem: Stone Game V
Difficulty: Hard

Approach:
- Use Dynamic Programming with interval DP.
- dp[l][r] represents the maximum score Alice can obtain from
  the subarray stoneValue[l...r].
- Use a prefix sum array to calculate the sum of any subarray in O(1).
- Try every possible split position k between l and r.
- Compare the sum of the left and right parts:
  - If leftSum < rightSum, the left part survives.
  - If rightSum < leftSum, the right part survives.
  - If both sums are equal, Alice can choose either part.
- Add the surviving part's sum to the best score of that subarray.
- Build the DP table from smaller intervals to larger intervals.

Time Complexity: O(n^3)
Space Complexity: O(n^2)
*/

class Solution {
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score for subarray l...r
        int[][] dp = new int[n][n];

        // Length of subarray
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len - 1 < n; l++) {

                int r = l + len - 1;

                // Try every possible split
                for (int k = l; k < r; k++) {

                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {

                        // Left part survives
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    } else if (rightSum < leftSum) {

                        // Right part survives
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    } else {

                        // Equal: Alice chooses either side
                        dp[l][r] = Math.max(
                            dp[l][r],
                            Math.max(
                                leftSum + dp[l][k],
                                rightSum + dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
