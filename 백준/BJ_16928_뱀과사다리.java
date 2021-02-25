package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928_뱀과사다리 {
	static int N, M, ls[];
	static int visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ls = new int[101];
		visited = new int[101];
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ls[x] = y;
		}
		bfs();
		System.out.println(visited[100]);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = 0;
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i = 1; i <= 6; i++) {
				int now = t + i;
				if (now > 100)
					continue;
				if(ls[now]!=0)
					now = ls[now];
				if(visited[now]==0) {
					visited[now]=visited[t]+1;
					q.offer(now);
				}
			}
		}
	}

}
