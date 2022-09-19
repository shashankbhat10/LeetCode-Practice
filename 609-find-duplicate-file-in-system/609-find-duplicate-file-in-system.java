class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] temp = path.split(" ", 0);
            for(int i=1; i<temp.length; i++){
                String fileName = temp[i].substring(0, temp[i].indexOf("("));
                String filePath = temp[0] + "/" + fileName;
                String content = temp[i].substring(temp[i].indexOf("(")+ 1, temp[i].length()-1);
                
                // System.out.println(filePath + ", " + content);
                if(!map.containsKey(content)){
                    List<String> files = new ArrayList<String>();
                    files.add(filePath);
                    map.put(content, files);
                } else {
                    List<String> files = map.get(content);
                    files.add(filePath);
                    map.put(content, files);
                }
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                res.add(map.get(key));
            }
        }
        
        return res;
    }
}