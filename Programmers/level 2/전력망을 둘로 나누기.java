import java.util.*;
class Solution {
    static List<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        list = new List[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] wire : wires){
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        for(int[] wire : wires){
            int cnt1 = bfs(wire[0],wire[1],n);
            int cnt2 = bfs(wire[1],wire[0],n);
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
        }
        return answer;
    }
    public int bfs(int i, int j, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n+1];
        int cnt = 0;
        q.offer(i);
        v[i] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            cnt++;
            for(int next : list[now]){
                if(next != j && !v[next]){
                    q.offer(next);
                    v[next] = true;
                }
            }
        }
        return cnt;
    }
}
