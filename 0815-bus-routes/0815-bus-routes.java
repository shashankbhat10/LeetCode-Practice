class Solution {
   class Pair{
      int v;
      int count;
      
      Pair(int v, int count){
          this.v = v;
          this.count = count;
      }
  }
  
  public  int numBusesToDestination(int[][] routes, int S, int T) {
      
      int n = routes.length;
      Map<Integer,Set<Integer>> network = new HashMap<>();
      
      for(int i = 0; i < n; ++ i){
          for(int j = 0; j < routes[i].length; ++ j){
              
              int v = routes[i][j];
              
              if(!network.containsKey(v)){
                  network.put(v, new HashSet<>());
              }
              
              network.get(v).add(i);
          }
      }
      
      Queue<Pair> mq = new LinkedList<>();
      mq.add(new Pair(S, 0));
      boolean visited[] = new boolean[n];
      
      
      while(!mq.isEmpty()){
          
          Pair p = mq.remove();
          
          if(p.v == T){
              return p.count;
          }
          
          
          for(int busNo : network.get(p.v)){
              
              if(visited[busNo]){
                  continue;
              }
              
              visited[busNo] = true;
              
              for(int x : routes[busNo]){
                  mq.add(new Pair(x, p.count + 1));
              }
              
          }
          
          
      }
      
      return -1;
  }

}