package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607 {
	static int N,R,T;
	static int MOD = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			long fac[] = new long[N + 1];
            fac[0] = 1;
            for (int i = 1; i <= N; i++) 
            	fac[i] = (fac[i - 1] * i) % MOD;
            long bottom = (fac[R] * fac[N - R]) % MOD;
            long reBottom = fermat(bottom, MOD - 2);
			System.out.println("#"+t+" "+(fac[N] * reBottom) % MOD);
		}
	}

    private static long fermat(long n, int x) {
        if (x == 0) return 1;
        long tmp = fermat(n, x / 2);
        long ret = (tmp * tmp) % MOD;
        if (x % 2 == 0) return ret;
        else return (ret * n) % MOD;
    }
}
