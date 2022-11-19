class Solution {
    public boolean canJump(int[] arr) {
     int ans = 0;
        for(int i  = 0 ; i < arr.length ;i++){
            if(i > ans){
                return false;
            }

            ans = Math.max(ans,i + arr[i]);
        }
       return true;
    }
}