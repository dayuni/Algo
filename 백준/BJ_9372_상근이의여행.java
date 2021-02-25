package study10월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9372_상근이의여행 {
	static int T, N, M,ans;
	static boolean visited[];
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int [N+1][N+1];
			visited = new boolean[N+1];
			ans=0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b]=1;
				arr[b][a]=1;

			}
			bfs();
			System.out.println(ans-1);

		}
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			ans++;
			int num = q.poll();
			for(int i=1;i<=N;i++) {
				if(arr[num][i]!=0&&!visited[i]) {
					visited[i]=true;
					q.add(i);
					}
			}
		}
	}
}
