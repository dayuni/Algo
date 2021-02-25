package study_10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11052_카드구매하기 {
	static int n, p[], d[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		p = new int[n + 1];
		d = new int[n + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());	
		}

		/*
		  	카드 i개가 필요할 때 
		  	p1 + i-1개
		  	p2 + i-2개
		  	p3 + i-3개 
		  	-> d[i] = p[n]+d[i-n] 
		  	이 중 최대값을 찾아야하니까 n도 1부터 i까지 확인
		  
		 */
		for (int i = 1; i <= n; i++) {						
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], p[j] + d[i - j]); // 현재 d의 값과 p[j]와 d[i-j]값을 비교해 최대만 
			}
		}
		
		System.out.println(d[n]);
	}
}
