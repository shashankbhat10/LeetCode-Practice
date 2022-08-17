class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for(String s : words){
            String temp = "";
            for(char ch : s.toCharArray()){
                temp += morse[ch - 'a'];
            }
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        }
        
        return hm.size();
    }
}