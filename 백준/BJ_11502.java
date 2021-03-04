package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11502 {
	static int T,K;
	static boolean prime[] = new boolean[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		// 에라토스테네스의 체로 소수 구함 
		for(int i=2;i*i<=1000;i++) {
			for(int j=i*i;j<=1000;j+=i)
				if(!prime[j])
					prime[j]=true;
		}
	
		
		for(int t=0;t<T;t++) {
			K = Integer.parseInt(in.readLine());
			int cnt =0;

			loop:
				for(int i=2;i<K;i++) {
					for(int j=2;j<K;j++) {
						for(int k=2;k<K;k++) {
							if(!prime[i]&&!prime[j]&&!prime[k]&&i+j+k==K) {	// 세개다 소수이고 합이 K인 경우 
								cnt++;
								System.out.println(i+" "+j+" "+k);			// 답 출력
								break loop;
							}
						}
					}
				}
			if(cnt==0)System.out.println(0);
		}
	}
	
}
