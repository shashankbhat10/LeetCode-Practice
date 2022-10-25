class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0;
        int j=0;
        int index1 = 0;
        int index2 = 0;
        
        while(index1 < word1.length || index2 < word2.length){
            if(index1 >= word1.length || index2 >= word2.length)
                return false;
            if(word1[index1].charAt(i) == word2[index2].charAt(j)){
                i++;
                j++;
            } else {
                return false;
            }
            
            if(i >= word1[index1].length()){
                i = 0;
                index1++;
            }
            if(j >= word2[index2].length()){
                j = 0;
                index2++;
            }
        }
        return true;
    }
}