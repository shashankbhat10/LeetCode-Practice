class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null)
            return false;
        
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length())
            return false;
        
        int count = 0;
        int totalUnique = 0;
        int[] countMap = new int[26];
        
        for(int i=0; i < s1.length(); i++){
            countMap[s1.charAt(i) - 'a']++;
            countMap[s2.charAt(i) - 'a']--;
        }
        
        int totalMatch = 0;
        
        for(int i=0; i < 26; i++){
            if(countMap[i] == 0)
                totalMatch++;
        }
        
        if(totalMatch == 26)
            return true;
        
        int start = 0;
        int end = s1.length();
        // System.out.println(totalMatch);
        while(end < s2.length()){
            countMap[s2.charAt(end) - 'a']--;
            // System.out.println(s2.charAt(end) + ": " + countMap[s2.charAt(end) - 'a']);
            if(countMap[s2.charAt(end) - 'a'] == 0)
                totalMatch++;
            else if(countMap[s2.charAt(end) - 'a'] == -1)
                totalMatch--;
            
            countMap[s2.charAt(start) - 'a']++;
            // System.out.println(s2.charAt(start) + ": " + countMap[s2.charAt(start) - 'a']);
            if(countMap[s2.charAt(start) - 'a'] == 0)
                totalMatch++;
            else  if(countMap[s2.charAt(start) - 'a'] == 1)
                totalMatch--;
            
            // System.out.println(totalMatch);
            if(totalMatch == 26)
                return true;
            
            start++;
            end++;
        }
        return false;
    }
}