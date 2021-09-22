package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, arr[], out[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		arr = new int[n];
		out = new int[m];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.print(sb.toString());
	}

	public static void dfs(int depth) {
		if (depth == m) {
			for (int num : out) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		int pre = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			if (pre != arr[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				pre = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}

		}
	}

}
