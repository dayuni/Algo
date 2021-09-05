import java.util.*;

public class Solution {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			answer[i] = check(places[i]);
		}
		return answer;
	}

	public int check(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'P') {
					if (!bfs(arr, i, j))
						return 0;
				}
			}
		}
		return 1;
	}

	public boolean bfs(String[] arr, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[arr.length][arr.length];
		q.offer(new Point(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int distance = Math.abs(x - nx) + Math.abs(y - ny);

				if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
					continue;
				if (visited[nx][ny] || distance > 2)
					continue;

				visited[nx][ny] = true;
				if (arr[nx].charAt(ny) == 'X')
					continue;
				else if (arr[nx].charAt(ny) == 'P')
					return false;
				else
					q.offer(new Point(nx, ny));
			}
		}
		return true;
	}
}
