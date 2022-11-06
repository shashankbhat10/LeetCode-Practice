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
                    // System.out.println("before: " + min);
                    int temp = leftQueue.remove();
                    // System.out.println("after: " + leftQueue.peek());
                } else {
                    min = rightMin;
                    // System.out.println("before: " + min);
                    int temp = rightQueue.remove();
                    // System.out.println("after: " + rightQueue.peek());
                }
                
                // System.out.println("here");
                // System.out.println("fixed: " + candidates*2);
                // System.out.println("size: " + (leftQueue.size() + rightQueue.size()));
                if(candidates*2-1 <= leftQueue.size() + rightQueue.size()){
                    // System.out.println("qweq");
                    // System.out.println("min: " + min);
                    // System.out.println("leftMin: " + leftMin);
                    // System.out.println("rightMin: " + rightMin);
                    if(min == leftMin){
                        // System.out.println("Here: " + costs[leftIndex]);
                        leftQueue.add(costs[leftIndex]);
                        leftIndex++;
                    } else {
                        // System.out.println("rightIndex: " + rightIndex);
                        rightQueue.add(costs[rightIndex]);
                        rightIndex--;
                    }
                }
            }
            
            // System.out.println(min);
            totalCost += (long) min;
        }
        return totalCost;
    }
}