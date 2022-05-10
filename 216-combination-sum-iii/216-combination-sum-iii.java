class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        combine(result, new ArrayList<>(), k, 1, n);
        
        return result;
    }
    
    private void combine(List<List<Integer>> list, List<Integer> tempList, int k, int start, int left){
        if(tempList.size() > k)
            return;
        else if(tempList.size() == k && left == 0)
            list.add(new ArrayList<Integer>(tempList));
        else{
            for(int i=start; i<=9; i++){
                tempList.add(i);
                combine(list, tempList, k, i+1, left-i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}