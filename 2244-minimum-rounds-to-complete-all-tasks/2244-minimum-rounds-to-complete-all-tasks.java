class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<tasks.length; i++){
            if(!hm.containsKey(tasks[i])){
                hm.put(tasks[i], 1);
            } else {
                hm.put(tasks[i], hm.get(tasks[i]) + 1);
            }
        }
        
        int count = 0;
        // int[] keys = hm.keySet().toArray();
        
        Iterator set = hm.keySet().iterator();
        while (set.hasNext()) {
            int key = (Integer) set.next();
            if(hm.get(key) == 1){
                return -1;
            } else {
                int temp = hm.get(key);
                System.out.println("temp: " + temp);
                if(temp % 3 == 1){
                    count += (temp - 3) / 3 + 2;
                } else if(temp % 3 == 2){
                    count += (temp - 1) / 3 + 1;
                } else {
                    count += temp / 3;
                }
            }
        }
        // for(int i=0; i<keys.length; i++){
        //     if(hm.get(keys[i]) == 1){
        //         return -1;
        //     } else {
        //         int temp = hm.get(keys[i]);
        //         System.out.println("temp: " + temp);
        //         if(temp % 3 == 1){
        //             count += (temp - 1) / 3 + 2;
        //         } else if(temp % 3 == 2){
        //             count += (temp - 1) / 3 + 1;
        //         } else {
        //             count += temp / 3;
        //         }
        //     }
        //     System.out.println("count: " + count);
        // }
        
        return count;
    }
}