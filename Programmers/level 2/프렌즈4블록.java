import java.util.*;

class Solution {
    static char[][] arr, tmp;
    static int answer = 0;
    static int M,N;
    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        M = m;N = n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        while(check());
        return answer;
    }
    
    public static boolean check(){
        boolean[][] v = new boolean[M][N];
        int cnt = 0;
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(arr[i][j]=='0')continue;
                if(arr[i][j]==arr[i][j+1] && arr[i][j]==arr[i+1][j] && arr[i][j]==arr[i+1][j+1]){
                    v[i][j] = true;
                    v[i][j+1] = true;
                    v[i+1][j] = true;
                    v[i+1][j+1] = true;
                }
            }
        }
        for(int i=0;i<N;i++){
            List<Character> tmp = new ArrayList<>();
            for(int j=M-1;j>=0;j--){
                if(v[j][i]){
                    cnt++;
                    continue;
                }
                tmp.add(arr[j][i]);
            }
            for(int j=M-1,k=0;j>=0;j--,k++){
                if(k<tmp.size()) arr[j][i] = tmp.get(k);
                else arr[j][i]='0';
            }
        }        
        answer+=cnt;
        return cnt > 0 ? true:false;
    }

}
