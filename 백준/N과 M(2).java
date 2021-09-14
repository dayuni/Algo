import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[m];
		dfs(arr,0,1,n,m);
		System.out.println(sb);
	}

	public static void dfs(int arr[], int depth,int idx, int n, int m) {
		if (depth == m) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = idx; i <= n; i++) {
				arr[depth] = i;
				dfs(arr,depth+1,i+1,n,m);
		}

	}
}
