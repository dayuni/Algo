class Solution {
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int[][] out = new int[dungeons.length][dungeons[0].length];
        dfs(0,dungeons,visited,out,k);
        return max;
    }
    static void dfs(int depth,int[][] dgs,boolean[] visited,int[][] out,int k){
        if(depth==dgs.length){
            int count = 0;
            for(int i=0;i<dgs.length;i++){                
                if(out[i][0]<=k){         
                    k -= out[i][1];                    
                    count++;
                }
            }
            max = Math.max(count,max);
            return;
        }
        for(int i=0;i<dgs.length;i++){
            if(visited[i])continue;
            visited[i] = true;
            out[depth][0] = dgs[i][0];
            out[depth][1] = dgs[i][1];
            dfs(depth+1,dgs,visited,out,k);
            visited[i] = false;            
        }
    }
}
