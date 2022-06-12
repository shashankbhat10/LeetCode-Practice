class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int l = 0;
        int r = 0;
        int score = 0;
        
        while(r < nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if(map.get(nums[r]) == 2){
                maxScore = Math.max(maxScore, score);
                score += nums[r];
                while(l <= r && map.get(nums[r]) != 1){
                    map.put(nums[l], map.get(nums[l]) - 1);
                    score -= nums[l];
                    l++;
                }
            } else {
                score += nums[r];
            }
            r++;
        }
        
        return Math.max(maxScore, score);
    }
}