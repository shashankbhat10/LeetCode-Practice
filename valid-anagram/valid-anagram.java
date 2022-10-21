class Solution {
    public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length())
//             return false;
        
//         int[] strHash = new int[26];
        
//         for(int i=0; i<s.length(); i++){
//             strHash[s.charAt(i) - 'a']++;
//         }
        
//         for(int i=0; i<t.length(); i++){
//             strHash[t.charAt(i) - 'a']--;
//             if(strHash[t.charAt(i) - 'a'] < 0)
//                 return false;
//         }
        
//         return true;
        
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        for(char c : hm.keySet()){
            if(hm.get(c) != 0)
                return false;
        }
        
        return true;
    }
}