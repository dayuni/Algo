package study_10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4811_알약 {
	static long[][] dp;
	static int n;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// dp[한 알 개수][반 알 개수]에 문자열 개수 저장
		dp = new long[31][31];
		dp[1][0]=1;
		dp[2][0]=2;
		dp[3][0]=5;
		
		eat(30,0);
		
		while(true) {
			n = Integer.parseInt(in.readLine());
			if(n==0)break;
			System.out.println(dp[n][0]);
		}
		
	}
 	private static long eat(int one,int half) {
 		// 한 알 없고 반 알만 있는 경우
 		if(one==0) return 1;
 		
 		// dp에 이미 저장되있는 경우
 		if(dp[one][half]!=0)return dp[one][half];
 		
 		long cnt =0;
 		
 		// 한 알 짜리 있을 때
 		if(one!=0) {
 			// 한 알 꺼내기 ( 반 알 쪼개서 다시 넣으니까 half+1)
 			cnt+=eat(one-1,half+1);
 		}
 		// 반 알 짜리 있을 때 ( 한 알 그대로 반 알 먹으니까 half -1)
 		if(half!=0) {
 			cnt+=eat(one,half-1);
 		}
 		
 		return dp[one][half]=cnt;
 	}
}
