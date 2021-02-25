package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932 {
	static int n,arr[][],dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) { 
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1;j<=i;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = arr[1][1];
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(j==1) dp[i][j]  = dp[i-1][j]+arr[i][j];
				else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+arr[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.println(max);
			
	}
}
