class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] nDigits = getDigits(n);
        
        int i = 1;
        while(i <= Math.pow(10, 9)){
            char[] powDigits = getDigits(i);
            if(Arrays.equals(powDigits, nDigits))
                return true;
            
            i *= 2;
        }
        
        return false;
    }
    
    public char[] getDigits(int n){
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }
}