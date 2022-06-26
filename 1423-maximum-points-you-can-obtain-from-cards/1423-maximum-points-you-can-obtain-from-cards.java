class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalScore = 0;
        int currScore = 0;
        int n = cardPoints.length;
        int minScore = 0;
        
        for(int i=0; i<n; i++){
            totalScore += cardPoints[i];
            currScore += cardPoints[i];
            if(i < (n-k)){
                minScore = currScore;
            } else {
                currScore -= cardPoints[i - n + k];
                minScore = Math.min(minScore, currScore);
            }
        }
        return totalScore - minScore;
    }
}