class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // if(left == letters.length - 1 && letters[left])
        
        return letters[left] <= target ? letters[0] : letters[left];
    }
}