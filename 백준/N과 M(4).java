import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new boolean[n];
		dfs(0,n,m,0);
		System.out.println(sb);
	}

	public static void dfs(int depth, int n, int m, int pre) {
		if (depth == m) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= n; i++) {
				if(i<pre) {
					continue;
				}
				arr[depth] = i;
				pre =i;
				dfs(depth+1,n,m,pre);
		}

	}
}
