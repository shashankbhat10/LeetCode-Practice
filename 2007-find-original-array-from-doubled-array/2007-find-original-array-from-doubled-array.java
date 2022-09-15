class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] empty = new int[0];
        int n= changed.length;
        if(n%2!=0)
            return empty;
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] ans = new int[(changed.length/2)];
     
        for(int i=0;i<n;i++)
            hm.put(changed[i], hm.getOrDefault(changed[i],0)+1);
        
        int temp = 0;
        
        Arrays.sort(changed);
        
        for(int i: changed) {
            if(hm.get(i)<=0) {
                continue;
            }
         
            if(hm.getOrDefault(2*i,0)<=0)
            {
                return empty;
            }
            ans[temp++] = i;
            
            hm.put(i, hm.get(i)-1); 
            hm.put(2*i, hm.get(2*i)-1);
        }
        
        return ans;
    }
}