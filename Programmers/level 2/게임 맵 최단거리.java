import java.util.*;
class Solution {
    static int[] dx = { -1, 0, 1, 0 },dy = { 0, -1, 0, 1 };
    static int n,m;
    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    public int solution(int[][] maps) {
        boolean visited[][] = new boolean[maps.length][maps[0].length];
        n = maps.length;
        m = maps[0].length;

        return bfs(maps,visited,0,0);
    }
    public static int bfs(int[][] maps,boolean[][] visited,int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,1));
        visited[x][y]=true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.x==n-1&&node.y==m-1) {
                return node.cnt;
            }
            for(int i=0;i<4;i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m)continue;
                if(!visited[nx][ny]&&maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new Node(nx,ny,node.cnt+1));
                }
            }
        }
        return -1;
    }
}
