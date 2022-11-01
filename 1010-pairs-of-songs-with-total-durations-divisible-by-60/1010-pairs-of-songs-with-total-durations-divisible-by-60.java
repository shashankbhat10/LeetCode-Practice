class Solution {
    public int numPairsDivisibleBy60(int[] time) {
//         int[] count = new int[60];
//         for(int i=0; i<time.length; i++){
//             count[time[i] % 60]++;
//         }
        
//         int sum = 0;
//         for(int i=1; i<30; i++){
//             // if(i == 0 || i == 30){
//             //     sum += (count[i] * (count[i]-1)) / 2;
//             //     System.out.println(sum);
//             // } else {
//                 sum += count[i] * count[60 - i];
//             // }
//         }
        
//         return sum + count[0] * (count[0] - 1) / 2 + count[30] * (count[30] - 1) / 2;
        // int ans = 0, cnt[] = new int[60];
        // for (int i = 0; i < time.length; i ++) cnt[time[i] % 60] += 1;
        // for (int i = 1; i< 30; i ++) ans += cnt[i] * cnt[60 - i];
        // return ans + cnt[0] * (cnt[0] - 1) / 2 + cnt[30] * (cnt[30] - 1) / 2;
        
        
        // int n=time.length;
        // int[] rem=new int[60];
        // for(int i=0;i<n;i++)
        // {
        //     rem[time[i]%60]++;
        // }
        // int count=0;
        // count+=(rem[0]*(rem[0]-1))/2;
        // count+=(rem[30]*(rem[30]-1))/2;
        // for(int i=1;i<=29;i++)
        // {
        //     count+=rem[i]*rem[60-i];
        // }
        // return count;
        
        HashMap <Integer,Integer> mp = new HashMap<>(); long res=0;
        for(int i=0; i<time.length; i++) mp.put(time[i]%60, mp.getOrDefault(time[i]%60, 0)+1);
        for(int e: mp.keySet()){
            if(e==30 || e==0) {
                if(mp.get(e)%2==0) res+= (mp.get(e)/2)*(mp.get(e)-1);
                else res+= ((mp.get(e)-1)/2)*mp.get(e);
            }
            else if(mp.containsKey(60-e)) {
                res+= mp.get(e)*mp.get(60-e);
                mp.put(e, 0);
                mp.put(60-e, 0);
            }
        }
        return (int)res;
    }
}