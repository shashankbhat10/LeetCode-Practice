class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
// 		int[] result = new int[nums.length - k + 1];
// 		int resultIndex = 0;
// 		Deque<Integer> queue = new ArrayDeque<>();
// 		int i = 0;
// 		while(i < nums.length) {
// 			while(!queue.isEmpty() && queue.peek() < i - k + 1) {
// 				queue.poll();
// 			}

// 			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
// 				queue.pollLast();
// 			}

// 			queue.add(i);
// 			if(i >= k - 1) {
// 				result[resultIndex++] = nums[queue.peek()];
// 			}
// 			i++;
// 		}

// 		return result;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        int resultIndex = 0;
        while(index < n) {
            while(!queue.isEmpty() && queue.peek() < index - k + 1)
                queue.poll();
            
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[index]) 
                queue.pollLast();
            
            queue.add(index);
            if(index >= k - 1) {
                // System.out.println(index);
                result[resultIndex++] = nums[queue.peek()];
            }
            index++;
        }
        
        return result;
    }
}