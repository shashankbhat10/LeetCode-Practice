class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        List<List<Integer>> rooms = new ArrayList<>();
        
        int maxSize = 0;
        for(int[] interval : intervals) {
            boolean added = false;
            List<Integer> temp = new ArrayList<>();
            temp.add(interval[0]);
            temp.add(interval[1]);
            
            for(List<Integer> room : rooms) {
                if(room.get(1) > temp.get(0))
                    continue;
                else {
                    room.set(0, temp.get(0));
                    room.set(1, temp.get(1));
                    added = true;
                    break;
                }
            }
            
            if(!added) {
                rooms.add(temp);
                maxSize = Math.max(maxSize, rooms.size());
            }
        }
        
        return maxSize;
    }
}