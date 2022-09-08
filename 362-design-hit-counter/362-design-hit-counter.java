class HitCounter {
    private int[] hitlist;
    private int index;
    public HitCounter() {
        this.hitlist = new int[300];
        this.index = 0;
    }
    
    public void hit(int timestamp) {
        this.hitlist[this.index++] = timestamp;
    }
    
    public int getHits(int timestamp) {
        int i = 0;
        while(i < index && this.hitlist[i] <= timestamp - 300)
            i++;
        
        int result = 0;
        while(i < index && this.hitlist[i] <= timestamp){
            // System.out.println(this.hitlist[i]);
            result++;
            i++;
        }
        // System.out.println("");
        return result;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */