class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int[] check = new int[costs.length];
        long totalCost = 0;
        
        PriorityQueue<Integer> leftQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<Integer>();
        
        if(candidates*2 >= costs.length){
            for(int num : costs){
                leftQueue.add(num);
            }
        } else {
            int index = 0;
            while(index < candidates){
                leftQueue.add(costs[index]);
                index++;
            }
            index = 0;
            while(index < candidates){
                rightQueue.add(costs[costs.length - index - 1]);
                index++;
            }
        }
        
        int leftIndex = candidates;
        int rightIndex = costs.length - candidates - 1;
        for(int i=0; i<k; i++){
            int min = 0;
            if(candidates*2 >= costs.length - i){
                if(leftQueue.isEmpty()){
                    min = rightQueue.remove();
                } else if(rightQueue.isEmpty()){
                    min = leftQueue.remove();
                } else {
                    int leftMin = leftQueue.peek();
                    int rightMin = rightQueue.peek();
                    if(leftMin <= rightMin){
                        min = leftMin;
                        leftQueue.remove();
                    } else {
                        min = rightMin;
                        rightQueue.remove();
                    }
                }
            } else {
                int leftMin = leftQueue.peek();
                int rightMin = rightQueue.peek();
                if(leftMin <= rightMin){
                    min = leftMin;
                    int temp = leftQueue.remove();
                } else {
                    min = rightMin;
                    int temp = rightQueue.remove();
                }
                
                if(candidates*2-1 <= leftQueue.size() + rightQueue.size()){
                    if(min == leftMin){
                        leftQueue.add(costs[leftIndex]);
                        leftIndex++;
                    } else {
                        rightQueue.add(costs[rightIndex]);
                        rightIndex--;
                    }
                }
            }
            
            totalCost += (long) min;
        }
        return totalCost;
    }
}