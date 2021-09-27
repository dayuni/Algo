package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, cnt = 0, cnt2 = 0;
	static char arr[][], arr2[][];
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };
	static boolean visited[][], visited2[][];

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new char[n][n];
		arr2 = new char[n][n];
		visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				arr2[i][j] = str.charAt(j);
				if (str.charAt(j) == 'G') {
					arr2[i][j] = 'R';
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(arr, visited, i, j);
					cnt++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited2[i][j]) {
					bfs(arr2, visited2, i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt + " " + cnt2);
	}

	public static void bfs(char[][] c, boolean[][] v, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		v[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (c[p.x][p.y] == c[nx][ny] && !v[nx][ny]) {
					q.offer(new Point(nx, ny));
					v[nx][ny] = true;
				}
			}

		}
	}

}
