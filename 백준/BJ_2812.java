package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class BJ_2812 {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		String num = in.readLine();
		Stack<Integer> stack = new Stack<>();
		int cnt =0;
		for(int i=0;i<N;i++) {
			int now = num.charAt(i)-'0';
			while(cnt<K&&!stack.isEmpty()&&stack.peek()<now) {
				stack.pop();
				cnt++;
			}
			stack.add(now);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N-K;i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb);
	}
}
