class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList();
        
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        
        int[] count = new int[26];
        
        for(String s : strs){
            for(int i=0; i<26; i++){
                count[i] = 0;
            }
            
            for(int i=0; i<s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            
            StringBuilder hash = new StringBuilder("");
            for(int i=0; i<26; i++){
                hash.append(count[i]);
                hash.append(';');
            }
            
            String hashKey = hash.toString();
            if(!result.containsKey(hashKey)){
                result.put(hashKey, new ArrayList());
            }
            
            result.get(hashKey).add(s);
        }
        
        return new ArrayList(result.values());
    }
}