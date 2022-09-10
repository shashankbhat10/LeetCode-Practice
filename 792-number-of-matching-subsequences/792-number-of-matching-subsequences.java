class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        char[] sarr = s.toCharArray();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String word : words){
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        
        for(String word : hm.keySet()){
            int i=0;
            int j=0;
            
            char[] temp = word.toCharArray();
            while(i < s.length() && j < word.length()){
                if(sarr[i] == temp[j]){
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if(j == temp.length)
                count += hm.get(word);
        }
        return count;
    }
}