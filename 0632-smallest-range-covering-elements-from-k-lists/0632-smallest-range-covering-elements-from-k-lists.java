class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int res[]={-100000,100000};
        int k=nums.size();
        int max=Integer.MIN_VALUE;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));

        for(int i=0;i<k;i++){
            int mol=nums.get(i).get(0);
            int tba[]={mol,0,i};
            max=Math.max(max,mol);
            pq.add(tba);

        }
        while(true){
            int min[]=pq.poll();
            if(res[1]-res[0]>max-min[0]){
                res[0]=min[0];
                res[1]=max;
            }
            min[1]++;
            List<Integer> cl=nums.get(min[2]);
            if(min[1]==cl.size()){
                break;
            }else{
                min[0]=cl.get(min[1]);
                max=Math.max(max,cl.get(min[1]));
                pq.add(min);
            }
        }
        return res;
    }
}