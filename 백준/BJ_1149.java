package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
	static int n,arr[][],dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new int[n+1][3];
		dp = new int[n+1][3];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<3;i++) {
			arr[0][i]=0;
			dp[0][i]=0;
		}
		
		for(int i=1;i<=n;i++) {
			dp[i][0]= Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
			dp[i][1]= Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
			dp[i][2]= Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
			
		}
		System.out.println(Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]));
		
	}
}
