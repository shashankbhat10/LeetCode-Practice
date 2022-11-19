class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : piles){
            high = Math.max(high, num);
        }
        
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int pile : piles){
                count += pile / mid;
                if(pile % mid != 0){
                    count++;
                }
            }
            if(count > h){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}