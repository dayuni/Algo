package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_지뢰찾기 {
	static int n,ans, a[][];
	static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, -1, 1 };
	static char map[][];
	static boolean v[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			n = Integer.parseInt(in.readLine());
			map = new char[n][n];
			a = new int[n][n];
			v = new boolean[n][n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				String str = in.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '*')
						a[i][j] = -1;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					if (map[i][j] == '.') {
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if ((nx >= 0 && nx < n && ny >= 0 && ny < n) && map[nx][ny] == '*') {
								cnt++;
							}
						}
						a[i][j] = cnt;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(a[i][j]==0&&!v[i][j]) {
						ans++;
						v[i][j]=true;
						dfs(i,j);
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(a[i][j]>0&&!v[i][j]) {
						ans++;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans);
			System.out.println(sb);

		}
	}

	static void dfs(int x, int y) {

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if ((a[nx][ny] > 0) && !v[nx][ny])
					v[nx][ny] = true;
				if ((a[nx][ny] == 0) && !v[nx][ny]) {
					v[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}

}
