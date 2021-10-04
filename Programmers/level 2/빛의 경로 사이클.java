import java.util.*;
class Solution {
    static int R, C;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
    static boolean[][][] visited;
    public int[] solution(String[] grid) {
        List<Integer> ans = new ArrayList<Integer>();
        R = grid.length;
        C = grid[0].length();
        visited = new boolean[R][C][4];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        ans.add(go(grid,i,j,d));
                    }
                }
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public static int go(String arr[],int x, int y, int d){
        int cnt =0;
        while(true){
            if(visited[x][y][d])break;
            cnt++;
            visited[x][y][d] = true;
            if(arr[x].charAt(y)=='L')
                d = (d+3)%4;
            else if(arr[x].charAt(y)=='R')
                d = (d+1)%4;
            
            x = (x+R+dx[d])%R;
            y = (y+C+dy[d])%C;
        }
        return cnt;
    }
}
