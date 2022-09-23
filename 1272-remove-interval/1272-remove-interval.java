class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int remStart = toBeRemoved[0];
        int remEnd = toBeRemoved[1];
        
        List<List<Integer>> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(interval[0] < remStart){
                res.add(Arrays.asList(interval[0], Math.min(interval[1], remStart)));
            }
            if(interval[1] > remEnd){
                res.add(Arrays.asList(Math.max(interval[0], remEnd), interval[1]));
            }
        }
        return res;
    }
}