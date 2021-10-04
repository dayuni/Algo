import java.util.LinkedList;
import java.util.Queue;

class Solution {
   static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Node> q = new LinkedList<>();
	static boolean[][] visited;
	static int size = 0;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] > 0 && !visited[i][j]) {
					size = 1;
					bfs(picture, i, j, m, n);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);

				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static void bfs(int[][] pic, int x, int y, int m, int n) {
		q.offer(new Node(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if (pic[nx][ny] == pic[x][y] && !visited[nx][ny]) {
						q.offer(new Node(nx, ny));
						visited[nx][ny] = true;
						size++;
					}
				}
			}
		}
	}
}
