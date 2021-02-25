package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1234 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			String token = st.nextToken();

			for (int i = 0; i < n; i++) {
				int num = token.charAt(i) - '0';
				if (stack.isEmpty()) {
					stack.push(num);
					continue;
				}
				if (stack.peek() == num) {
					stack.pop();
				} else
					stack.push(num);
			}
			int size = stack.size();
			int ans[] = new int[size];
			for (int i = size-1; i >=0; i--) {
				ans[i] = stack.pop();
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < size; i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
		}
	}
}
