class Solution {
    public List<List<Integer>> generate(int numRows) {

        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j <= i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                row.add(dp[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
