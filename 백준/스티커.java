import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,S,cnt =0,arr[];
    static boolean visited[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(in.readLine());
            int arr[][] = new int[2][N+2];
            int dp[][] = new int[2][N+2];
            for(int i=0;i<2;i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                for(int j=1;j<=N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int i=2;i<=N;i++){
                dp[0][i] = arr[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
                dp[1][i] = arr[1][i]+Math.max(dp[0][i-1],dp[0][i-2]);
            }
            System.out.println(Math.max(dp[0][N],dp[1][N]));

        }

    }

}
