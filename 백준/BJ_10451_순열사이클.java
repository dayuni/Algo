package study_9월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10451_순열사이클 {
	static int T, N, arr[],cnt=0;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			visited = new boolean[N];
			cnt=0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				if(!visited[i]) {
				dfs(i);
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void dfs(int i) {
		if(visited[i]) {
			cnt++;
			return;
		}
		int next;
		visited[i]=true;
		next = arr[i]-1;
		dfs(next);
	}
}
