package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	static int n, m;
	static int map[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<Node> q = new LinkedList<>();

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String token = st.nextToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = token.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(map[n-1][m-1]);
	}

	static void bfs(int x, int y) {
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node t = q.poll();
			int px = t.x;
			int py = t.y;
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited[nx][ny] = true;
					map[nx][ny]=map[px][py]+1;
				}
			}
		}

	}
}
