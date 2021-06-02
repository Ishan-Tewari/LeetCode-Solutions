class Solution {

    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        dp = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return check(s1,s2,s3,0,0,0);
    }

    public boolean check(String s1, String s2, String s3, int i, int j, int k){

        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        if (i == n && j == m && k == l) return true;
        else if (k == l) return false;

        if (dp[i][j] != -1){
            if (dp[i][j] == 1) return true;
            else return false;
        }

        boolean ans = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            ans = ans || check(s1,s2,s3,i+1,j,k+1);
        }

        if (j < m && s2.charAt(j) == s3.charAt(k)){
            ans = ans || check(s1,s2,s3,i,j+1,k+1);
        }

        if (ans == false) dp[i][j] = 0;
        else dp[i][j] = 1;

        if (dp[i][j] == 1) return true;
        else return false;
    }
}
