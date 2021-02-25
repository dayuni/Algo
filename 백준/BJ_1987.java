package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987 {
	static int R, C, max = 1, cnt = 1;
	static char map[][];
	static boolean[] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 상하 좌우;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0);
		System.out.println(max);

	}

	static void dfs(int y, int x) {
		char alpha = map[y][x];
		visited[alpha - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= C || ny < 0 || ny >= R)
				continue;
			int nextAlpha = map[ny][nx];
			if (visited[nextAlpha - 'A'])
				continue;
			++cnt;
			if (max < cnt)
				max = cnt;
			dfs(ny, nx);
		}
		cnt--;
		visited[alpha - 'A'] = false;
	}
}
