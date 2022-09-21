class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        
        int sum = 0;
        for(int num : nums){
            if(num % 2 == 0)
                sum += num;
        }
        
        int index = 0;
        for(int[] query : queries){
            if(nums[query[1]] % 2 == 0){
                if((nums[query[1]] + query[0]) % 2 == 0){
                    sum += query[0];
                    res[index] = sum;
                } else {
                    sum -= nums[query[1]];
                    res[index] = sum;
                }
            } else {
                if((nums[query[1]] + query[0]) % 2 == 0){
                    sum += nums[query[1]] + query[0];
                    res[index] = sum;
                } else {
                    res[index] = sum;
                }
            }
            nums[query[1]] = nums[query[1]] + query[0];
            index++;
        }
        
        return res;
    }
}