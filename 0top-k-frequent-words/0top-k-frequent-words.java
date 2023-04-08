class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        List<String> res = new ArrayList<String>();
        for(int i = 0; i<words.length; i++){
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<String>((w1, w2) -> hm.get(w1).equals(hm.get(w2)) ? w2.compareTo(w1) : hm.get(w1) - hm.get(w2));
        
        for(String word : hm.keySet()){
            queue.add(word);
            if(queue.size() > k)
                queue.poll();
        }
        
        while(!queue.isEmpty()){
            res.add(queue.remove());
        }
        
        Collections.reverse(res);
        return res;
    }
}