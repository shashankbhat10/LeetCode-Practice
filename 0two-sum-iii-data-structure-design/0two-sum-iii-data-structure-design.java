class TwoSum {
    HashMap<Integer, Integer> hm; 
    public TwoSum() {
        hm = new HashMap<>();
    }
    
    public void add(int number) {
        hm.put(number, hm.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        Set<Integer> set = hm.keySet();
        
        if(set.isEmpty())
            return false;
        
        for(int num : set) {
            int toFind = value - num;
            if(toFind == num) {
                if(hm.get(toFind) > 1)
                    return true;
            } else {
                if(set.contains(toFind))
                    return true;
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */