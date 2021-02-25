package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에
 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어  그 배추들 역시 해충으로부터 보호받을 수 있다.
(한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)
한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다. 
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.
(0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.)
 */
public class BJ_1012 {
	static int m, n, k, cnt = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			cnt = 0;
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken()); // 가로
			m = Integer.parseInt(st.nextToken()); // 세로
			k = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치 개수

			map = new int[m][n];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1; // 배추의 위치에 1을 입력
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {// 배추가 있을 때
						dfs(i, j); 		 // dfs 호출 
						cnt++;			 // dfs가 호출 된 만큼 cnt 증가
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {

		for (int i = 0; i < 4; i++) {
			// 다음에 방문할 곳 4방탐색
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= m || ny < 0 || ny >= n) {// 범위 벗어나면 continue
				continue;
			}
			if (map[nx][ny] == 0) // map이 0일 때 continue
				continue;

			map[nx][ny] = 0; // 이미 방문한 곳 0으로 바꿔줌 
			dfs(nx, ny); // 다음위치 탐색
		}
	}
}
