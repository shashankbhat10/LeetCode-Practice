/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int temp = 0;
        for(int i=1; i<n; i++) {
            if(knows(temp, i))
                temp = i;
        }
        
        for(int i=0; i<n; i++) {
            if(i != temp && knows(temp, i) || !knows(i, temp))
                return -1;
        }
        
        return temp;
    }
}