import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int t[] = new int[N+2];
        int p[] = new int[N+2];
        int dp[] = new int[N+2];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N+1;i++){
            max = Math.max(dp[i],max);
            if(i+t[i]<=N+1){
                dp[i+t[i]]=Math.max(max+p[i],dp[i+t[i]]);
            }
        }
        System.out.println(max);

    }
}
