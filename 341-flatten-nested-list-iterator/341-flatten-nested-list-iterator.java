/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList(nestedList);
    }
    
    private void flattenList(List<NestedInteger> nestedList) {
        while(nestedList.size() > 0){
            if(!nestedList.get(0).isInteger()){
                List<NestedInteger> list = nestedList.get(0).getList();
                flattenList(list);
                nestedList.remove(0);
            } else {
                queue.add(nestedList.get(0));
                nestedList.remove(0);
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return queue.poll().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if(!queue.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */