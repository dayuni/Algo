package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(in.readLine());
		int bit = 0;
		/*
		 길이가 N인 이진수 : 0~N-1로 구성된 부분집합으로 나타낼 수 있음  

		x가 들어있는지 알고 싶다면, S & (1<<x) -> x번째 1을 넣어서 &연산 
		
		x를 추가하고 싶다면, S | (1<<x) -> +연산은 중복된 비트 덧셈 시 에러 
		
		x를 제거하고 싶다면, S & ~(1<<x) -> 제거하려는 위치만 0, 나머지는 1 &연산 
		
		x를 토글, S^(1<<x) 
		 */
		for (int i = 0; i < M; i++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			String op = st.nextToken();			
			int num;
			switch(op) {
				case "add" :
					num = Integer.parseInt(st.nextToken());
					bit |=(1<<(num-1));
					break;
				case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    bit = bit & ~(1 << (num - 1));
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    bit ^= (1 << (num - 1));
                    break;
                case "all" :
                    bit |= (~0);
                    break;
                case "empty" :
                    bit &= 0;
                    break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
