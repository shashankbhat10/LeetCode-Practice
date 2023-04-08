class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>((c1, c2) -> hm.get(c2) - hm.get(c1));
        
        for(char ch : hm.keySet()) {
            queue.add(ch);
        }
        
        String result = "";
        
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            for(int i=0; i<hm.get(ch); i++) 
                result += String.valueOf(ch);
        }
        
        return result;
    }
}