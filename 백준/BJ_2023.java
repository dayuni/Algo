package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2023 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		dfs("",0);
		System.out.println(sb);
	}
	static void dfs(String str, int cnt) {
		if(cnt==N) {
			sb.append(str+"\n");
			return;
		}
		for (int i=1;i<=9;i++) {
			if(isPrime(Integer.parseInt(str+i))) {		//문자열에 소수인 숫자를 하나씩 더해줌
				dfs(str+i,cnt+1);
			}
		}
	}
	
	static boolean isPrime(int n) {
		if(n==1)return false;
		int sqrt = (int)Math.sqrt(n);
		for(int i=2;i<=sqrt;i++) {		// 제곱근으로 나누어 떨어지면 소수가 아님
			if(n%i==0) return false;
		}
		return true;
	}
}
