class Logger {
    Map<String, Integer> hm;
    public Logger() {
        hm = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!hm.containsKey(message)) {
            hm.put(message, timestamp);
            return true;
        } else {
            int time = hm.get(message);
            if(Math.abs(time - timestamp) < 10)
                return false;
            else {
                hm.put(message, timestamp);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */