class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxWindow = 0;
        int maxChar = 0;
        
        Map<Character, Integer> hm = new HashMap<Character, Integer>(); 
        
        while(right < s.length()){
            char ch = s.charAt(right);
            
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            maxChar = Math.max(maxChar, hm.get(ch));
            if(right - left - maxChar + 1 > k){
                char remove = s.charAt(left);
                hm.put(remove, hm.get(remove) - 1);
                left++;
            }
            
            maxWindow = Math.max(maxWindow, right - left + 1);
            right++;
        }
        
        return maxWindow;
    }
}