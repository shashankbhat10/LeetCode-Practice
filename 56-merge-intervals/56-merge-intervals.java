class Solution {
    public int[][] merge(int[][] intervals) {        
//         int[] start = new int[intervals.length];
//         int[] end = new int[intervals.length];
        
//         for(int i=0; i<intervals.length; i++){
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }

//         List<List<Integer>> result = new ArrayList<>();
//         int i=0;
//         int j=0;
        
//         while(i < intervals.length && j < intervals.length){
//             List<Integer> temp = new ArrayList<Integer>();
            
//             temp.add(start[i++]);
//             while(i<intervals.length && start[i] <= end[j]){
//                 j++;
//                 i++;
//             }
//             temp.add(end[j++]);
//             result.add(temp);
//         }
        
//         int[][] res = new int[result.size()][2];
//         for(int ii=0; ii<res.length; ii++){
//             res[ii][0] = result.get(ii).get(0);
//             res[ii][1] = result.get(ii).get(1);
//         }
        
//         return res;
        
        if(intervals.length < 2)
            return intervals;
        
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));        
        
        List<int[]> result = new ArrayList<>();
        int[] tempInterval = intervals[0];
        result.add(tempInterval);
        
        int count = 0;
        for(int[] interval : intervals){
            if(interval[0] <= tempInterval[1]){
                tempInterval[1] = Math.max(interval[1], tempInterval[1]);
            } else {
                tempInterval = interval;
                result.add(tempInterval);
                count++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}