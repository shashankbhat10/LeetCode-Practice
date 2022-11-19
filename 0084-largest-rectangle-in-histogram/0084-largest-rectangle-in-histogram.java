class Solution {
    public int largestRectangleArea(int[] heights) {
      int res = 0;
      int[] NSL = nearestSmallestLeft(heights);
      int[] NSR = nearestSmallestRight(heights); 
        
        
        // main calculation
        
    for(int i =0; i<heights.length;i++){
      int indexes = NSR[i] - NSL[i]-1;
        res = Math.max(res,indexes*heights[i]);
        
    }
      
    return res;
        
    }   
      
        
        // Nearest Smaller Element to left
        public int [] nearestSmallestLeft(int[] arr){
            int n = arr.length;
            int[] res = new int[n];
            Stack<Integer>st = new Stack<>();
            for(int i=0; i<n;i++){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i] = -1;
                }
                else{
                    res[i] = st.peek();
                }
                st.push(i);
            }
             return res;
        }
      
        
        // Nearest Smallest Element toi Right
        public int [] nearestSmallestRight(int[] arr){
            int n = arr.length;
            int [] res = new int[n];
            Stack<Integer> st = new Stack<>();
            for(int i= n-1; i>=0; i--){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i] = n;
                }
                else{
                    res[i] = st.peek();
                }
                st.push(i);
            }
             return res;
            
        }

}