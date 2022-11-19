class Solution {
    Map<Integer,List<Integer>> edges = new HashMap<>();
    int[][] memo;
    int dst;
    int n;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.memo = new int[n][k+2];
        this.dst = dst;
        this.n = n;
        for(int[] f: flights) edges.computeIfAbsent(f[0], (z)-> new ArrayList<>()).add(f[1]+f[2]*n);
        int resp = dfs(src,k+1);
        return resp>=Integer.MAX_VALUE/2?-1:resp;
    }

    int dfs(int node, int k) {
        if(node==dst) return 0;
        if(k==0) return Integer.MAX_VALUE/2;
        if(memo[node][k]!=0) return memo[node][k];
        int min = Integer.MAX_VALUE/2;
        if(edges.get(node)!=null) for(int e : edges.get(node)) min = Math.min(min,dfs(e%n,k-1)+e/n);
        return memo[node][k]=min;
    }
}