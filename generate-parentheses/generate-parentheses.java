class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        
        generatePattern(result, "", 0, 0, n);
        
        return result;
    }
    
    private void generatePattern(List<String> result, String temp, int open, int close, int max)     {
        if(temp.length() == max * 2){
            result.add(temp);
        }
        
        if(open < max){
            generatePattern(result, temp + "(", open + 1, close, max);
        }
        
        if(close < open){
            generatePattern(result, temp + ")", open, close + 1, max);
        }
    }
}