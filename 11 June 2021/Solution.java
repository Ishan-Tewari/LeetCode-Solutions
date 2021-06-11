class Solution {

    int[][] dp;
    public int stoneGameVII(int[] stones) {

        // initialize dp array with -1
        int n = stones.length;
        dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i],-1);

        // calculate sum of whole array
        int sum = 0;
        for (int i = 0; i < n; i++) sum += stones[i];

        // fill the dp table
        int ans = helper(0, n-1, stones, sum);
        return ans;
    }


    public int helper(int i, int j, int[] stones, int sum){

        // if only one element left, then after picking nothing will be left so diff = 0
        if (i == j) return 0;

        // if answer already calculated
        if (dp[i][j] != -1) return dp[i][j];

        // calculate answer
        int ans = Math.max(
            sum - stones[i] - helper(i+1,j,stones,sum-stones[i]),
            sum - stones[j] - helper(i,j-1,stones,sum-stones[j]));

        dp[i][j] = ans;
        return dp[i][j];
    }
}
