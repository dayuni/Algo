package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long dp[] = new long[n+1];
	
		dp[0]=1;	// 0일때 1가지
		dp[1]=3;	// 1일때 3가지
		
		for(int i=2;i<=n;i++) {				// 계산해봤을 때 2일때 7 3일때 17 임
			dp[i]=2*dp[i-1]+dp[i-2];		// 점화식대로 ㄱㄱ
			dp[i]%=9901;					// 9901으로 나머지 계산
		}
		
		System.out.println(dp[n]);
	}
}
