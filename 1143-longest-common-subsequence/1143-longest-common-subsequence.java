class Solution {
    int solve(int i, int j, String text1, String text2, int[][] dp){
        if(i==0 || j==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)) return 1 + solve(i-1,j-1,text1,text2,dp);

        return dp[i][j]=Math.max(solve(i-1,j,text1,text2,dp),solve(i,j-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // int[][] dp = new int[n+1][m+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return solve(n,m,text1,text2,dp);

        // for(int i =0; i<= n; i++) dp[i][0] =0;
        // for(int j =0; j<= m; j++) dp[0][j] =0;

        // for(int i =1; i<=n;i++){
        //     for(int j =1; j<=m;j++){
        //         if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1 + dp[i-1][j-1];

        //         else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //     }
        // }
        // return dp[n][m];

        int[] prev = new int[m+1];
        for(int j =0; j<=m;j++) prev[j]=0;
        for(int i =1; i<=n;i++){
            int[] curr = new int[m+1];
            Arrays.fill(curr,0);
            for(int j =1; j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                     curr[j]= 1 + prev[j-1];

                else curr[j]=Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}