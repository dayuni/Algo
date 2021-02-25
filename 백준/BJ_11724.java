package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11724 {
	static int N,M,arr[][],cnt=0;
	static boolean v[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		for(int i=1;i<=N;i++) {
			if(!v[i]) {
			dfs(i);
			cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int start) {
		if(v[start])
			return;
		else {
			v[start]=true;
			for(int i=1;i<=N;i++) {
				if(arr[start][i]==1) {
					dfs(i);
				}
			}
		}
	}
}
