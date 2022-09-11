class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        
        for(int i=0; i<arr.length; i++){
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }
        
        Arrays.sort(arr, (a, b) -> (b[0] - a[0]));
        
        long score = 0, totalSpeed = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        
        for(int i=0; i<arr.length; i++){
            if(q.size() >= k)
                totalSpeed -= q.remove();
            
            q.add(arr[i][1]);
            totalSpeed += arr[i][1];
            score = Math.max(score, totalSpeed * arr[i][0]);
        }
        
        return (int)(score % 1000000007);
        
//         int[][] players = new int[n][2];
//         for (int i=0; i<n; i++) {
//             players[i][0] = efficiency[i];
//             players[i][1] = speed[i];
//         }
// 		// Sort the players based on efficiency in decreasing order, as for each iteration, we'll consider only players with higher efficiency.
//         Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));

// 		// Priority-Queue to maintain players with highest relative speeds with efficiencies greater than the one under iteration.
//         PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
//         long teamPerformance = 0, teamSpeed = 0;

//         for (int i=0; i<n; i++) {
// 			// This is because a team can have atmost `k` players.
//             if (speedQueue.size() >= k) {
//                 teamSpeed -= speedQueue.remove();
//             }
//             speedQueue.add(players[i][1]);
//             teamSpeed += players[i][1];

//             teamPerformance = Math.max(teamPerformance, teamSpeed * players[i][0]);
//         }
//         return (int) (teamPerformance % 1000000007);
    }
}