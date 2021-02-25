package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2502_떡먹는호랑이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int fibo[][] = new int[31][2];
		fibo[1][0]=1; // 첫번쨰수
		fibo[2][1]=1; // 두번째수
		for (int i = 3; i <= D; i++) {
			for(int j=0;j<2;j++) {
				fibo[i][j]=fibo[i-2][j]+fibo[i-1][j];
			}
		}
		boolean flag = false;
		for (int i = 1; i <100000; i++) {
			for (int j = 1; j < 100000; j++) {
				if (K == fibo[D][0] * i + fibo[D][1] * j) {					
					System.out.println(i);
					System.out.println(j);
					flag = true;
					break;
				}
			}
			if(flag)break;
		}
	}
}
