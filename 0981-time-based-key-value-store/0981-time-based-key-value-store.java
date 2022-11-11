class TimeMap {
    
    HashMap<String,TreeMap<Integer,String>> map;
    
    public TimeMap() {
        map = new HashMap<String,TreeMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {

        TreeMap<Integer,String> tmap;
        // if key is not present create a new instance otherwise get that treemap which is already there in hashmap corresponding to key.
        if(map.get(key) != null)
            tmap = map.get(key);  
        else
            tmap = new TreeMap<>(Collections.reverseOrder());  
        // finally put key value in treemap and then in hashmap.
        tmap.put(timestamp,value);
        map.put(key,tmap);
        
    }
    
    public String get(String key, int timestamp) {
        // Iterate in hashmap first.
        for(Map.Entry m : map.entrySet()){
            // if key is equal to our hashmap key 
            if(m.getKey().equals(key)){
                // get the value which is treemap correspond to given key.
                TreeMap<Integer,String> tmap = (TreeMap<Integer,String>)m.getValue();
                // Iterate in treemap
                for(Map.Entry tm : tmap.entrySet()){
                    if((int)tm.getKey() <= timestamp) return String.valueOf(tm.getValue());
                }
            }
        }
        return "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */