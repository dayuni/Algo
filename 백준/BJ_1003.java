package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003 {
	static int N;
	static int dp0[]=new int[41];
	static int dp1[]=new int[41];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++) {

			N = Integer.parseInt(in.readLine());
			dp0[0]=1;dp1[0]=0;
			if(N>0)
				dp0[1]=0;dp1[1]=1;
			
			for(int j=2;j<=N;j++) {
				dp0[j]=dp0[j-1]+dp0[j-2];
				dp1[j]=dp1[j-1]+dp1[j-2];
			}
			System.out.println(dp0[N]+" "+dp1[N]);
		}
	}
	
}
