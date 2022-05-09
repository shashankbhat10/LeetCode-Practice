class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> comb = new ArrayList<String>();
        
        comb.add("");
        for(int i=0; i<digits.length(); i++){
            comb = combine(dict[digits.charAt(i)-'0'], comb);
        }
        
        return comb;
    }
    
    public List<String> combine(String digit, List<String> comb){
        List<String> res = new ArrayList<String>();
        
        for(int i=0; i<digit.length(); i++){
            for(String s : comb){
                res.add(s + Character.toString(digit.charAt(i)));
            }
        }
        
        return res;
    }
}