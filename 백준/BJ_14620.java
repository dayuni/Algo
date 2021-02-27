package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14620 {
	static int N, ans = Integer.MAX_VALUE;
	static int arr[][];
	static boolean v[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N + 1][N + 1];
		v = new boolean[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int cnt, int sum) {
		if (cnt == 3) {
			ans = Math.min(ans, sum);			// 최소비용을 찾기 위해 Math.min
		}
		else {
		for (int i = 2; i < N; i++) {			// 범위 안에서만 고려하기 위해 2부터 N미만까지 
			for (int j = 2; j < N; j++) {
				if (!v[i][j] && check(i, j)) {	// 방문 X , 사방도 방문 X인 경우 
					v[i][j] = true;				// 방문처리
					int tmp = arr[i][j];		// 현재 위치의 비용
					for (int k = 0; k < 4; k++) {	
						int nx = i + dx[k];
						int ny = j + dy[k];
						v[nx][ny] = true;		// 사방의 방문처리
						tmp += arr[nx][ny];		// 비용 더해줌
					}

					dfs(cnt + 1, sum + tmp);	// 재귀

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						v[nx][ny] = false;		// 사방 방문처리 초기화
					}
					v[i][j] = false;			// 방문 처리 초기화
				}
			}
		}
		}
	}

	static boolean check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (v[nx][ny])
				return false;
		}
		return true;
	}
}
