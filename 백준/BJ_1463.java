package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {
	static int N,dp[]=new int [10000001];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		dp[1]=0;
		
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) {
				dp[i]=Math.min(dp[i],dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i]=Math.min(dp[i],dp[i/3]+1);
			}
		}
		System.out.println(dp[N]);
	}
}
