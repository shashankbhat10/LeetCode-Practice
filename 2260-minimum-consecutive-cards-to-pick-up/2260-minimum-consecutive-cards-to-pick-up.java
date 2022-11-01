class Solution {
    public int minimumCardPickup(int[] cards) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
        
//         for(int i=0; i<cards.length; i++){
//             hm.put(cards[i], hm.getOrDefault(cards[i], 0) + 1);
//         }
        
//         int totalLessThanTwo = 0;
//         ArrayList<Integer> keys = new ArrayList<Integer>();
//         for(Integer i : hm.keySet()){
//             if(hm.get(i) < 2){
//                 keys.add(i);
//                 totalLessThanTwo++;
//             }
//         }
        
//         if(totalLessThanTwo == hm.keySet().size())
//             return -1;
        
//         for(int i=0; i<keys.size(); i++){
//             hm.remove(keys.get(i));
//         }
        
//         String number = "";
//         for(int i=0; i<cards.length; i++){
//             number += ";" + String.valueOf(cards[i]);
//         }
        
//         int minLength = Integer.MAX_VALUE;
//         for(Integer num : hm.keySet()){
//             System.out.println(num);
//             for(int i=0; i<hm.get(num)-1; i++){
//                 String temp = "";
//                 int index1 = number.indexOf(";" + String.valueOf(num));

//                 temp = number.substring(index1+1);
//                 System.out.println(temp);
//                 int index2 = temp.indexOf(";" + String.valueOf(num));
//                 System.out.println(index1);
//                 System.out.println(index2);
//                 int len = String.valueOf(num).length();
//                 int tempLen = 0;
//                 if(len > 1){
//                     tempLen = index2 + 2 - String.valueOf(num).length();
//                 } else {
//                     tempLen = index2 + 2;
//                 }
//                 minLength = Math.min(minLength, tempLen);
//             }
//         }
        
//         return minLength;
//         // return 1;
        
        Map<Integer, PriorityQueue<Integer>> hm = new HashMap<Integer, PriorityQueue<Integer>>();
        
        for(int i=0; i<cards.length; i++){
            if(!hm.containsKey(cards[i])){
                PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
                queue.add(i);
                hm.put(cards[i], queue);
            } else {
                PriorityQueue<Integer> queue = hm.get(cards[i]);
                queue.add(i);
                hm.put(cards[i], queue);
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        for(int key : hm.keySet()){
            PriorityQueue<Integer> queue = hm.get(key);
            if(queue.size() < 2)
                continue;
            else {
                int dist = 0;
                int prevIndex = queue.remove();
                while(!queue.isEmpty()){
                    int index = queue.peek();
                    minDistance = Math.min(minDistance, index - prevIndex + 1);
                    prevIndex = queue.remove();
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}