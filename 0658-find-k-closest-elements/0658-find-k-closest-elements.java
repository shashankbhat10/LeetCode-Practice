class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lp=0;
        int rp=arr.length-1;
        int windowSize=rp-lp+1;
        while(windowSize!=k)
        {
            if(Math.abs(x-arr[lp]) < Math.abs(x-arr[rp])) rp-- ;
            else if(Math.abs(x-arr[lp]) > Math.abs(x-arr[rp]))lp++ ;
            else{
                if(arr[lp]<arr[rp])rp--;
                else lp++;
            }
            windowSize=rp-lp+1;
        }
        List<Integer> res =new ArrayList<>();

        for(int i = lp;i<=rp;i++)
            res.add(arr[i]);
        return res;

        
    }
}