package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2942_퍼거슨과사과 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int gcd = GCD(R,G);
		
		for(int i=1;i<=gcd;i++) {
			if(gcd%i==0) {
				System.out.println(i+" "+(R/i)+" "+(G/i));
			}
		}
		
	}

	static int GCD(int x, int y) { // 유클리드호제법으로 최대공약수 구하기
		if (y == 0) {
			return x;
		} else {
			return GCD(y, x % y);
		}
	}

}
