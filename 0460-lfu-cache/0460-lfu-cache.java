class LFUCache {
    
    private Map<Integer, DataInfo> cache;
    private PriorityQueue<DataInfo> filterLFU;
    // used to keep track which key is inserted/updated at what time. Always increases
    private int timer; 
    private int capacity;
    
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        filterLFU = new PriorityQueue<>((a, b) -> {
            if(a.counter == b.counter)
                // ascending(val with smallest time first)
                return Integer.compare(a.time, b.time); 
            return Integer.compare(a.counter, b.counter);
        });
        this.capacity = capacity;
    }
    
    public int get(int key) {
        DataInfo data = cache.get(key);
        if(data == null) return -1;
        filterLFU.remove(data); // takes linear time [cause TLE], didn't know how get accepted
        data.counter = data.counter + 1;
        data.time = timer++;
        // Needs to delete from PQ & then push inorder to re-arrange the data
        // in PQ. This must be done when changing the content of an object which is 
        // stored in PQ from outside using its reference. 
        // Because heapify will take place after popping/deleting an element from PQ
        filterLFU.offer(data);
        return data.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(!cache.containsKey(key)) {
            if(cache.size() == capacity) {
                DataInfo data = filterLFU.poll();
                cache.remove(data.key); // this line i was missing
            }
            DataInfo data = new DataInfo(key, value, 1, timer++);
            cache.put(key, data);
            filterLFU.offer(data);
        } else {
            DataInfo data = cache.get(key);
            filterLFU.remove(data);
            data.counter = data.counter + 1;
            data.value = value; //blindly updating
            data.time = timer++;
            filterLFU.offer(data);
        }
    }
    
    private class DataInfo {
        int key;
        int value;
        int counter;
        /*
            this field 'time' is used to determine which key we've to 
            invalidate if there is a tie b/w two or more keys and current
            capacity reached to capacity of DS.
            
            The one with the smallest one has to removed from our DS.
        */
        int time;
        
        DataInfo(int key, int value, int counter, int time) {
            this.key = key;
            this.value = value;
            this.counter = counter;
            this.time = time;
        }
        
        @Override
        public String toString() {
            return "(" + "val:" + value + ","
                + "cnt:" + counter + ","
                + "tm:" + time  + ")";
        }
    }
}