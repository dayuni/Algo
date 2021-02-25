package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int r, c;
	static int dx[] = { -1, 1, 0, 0, };
	static int dy[] = { 0, 0, -1, 1 };
	static char map[][];
	static boolean flag = false;
	static Queue<Point> water = new LinkedList<>();					// 물 
	static Queue<Point> hedgehog = new LinkedList<>();				// 고슴도치

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String str = in.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*')
					water.offer(new Point(i, j));			// 물일때 물 큐에 넣어줌
				if (map[i][j] == 'S')						// 고슴도치일 때  고슴도치 큐에 넣어줌
					hedgehog.offer(new Point(i, j));
			}
		}
		int time = 0;
		while (true) {
			time++;
			if (hedgehog.size() == 0) {					// 고슴도치 큐가 비어있다면 
				System.out.println("KAKTUS");			// 탈출에 실패한거임 (밑에서 탈출구 만날 때 큐에 넣어주기때문 )
				return;
			}	
			water();									// 물이 찰 예정인곳으로 고슴도치가 못가니까 물 먼저 채워줌
			hedgehog();									// 고숨도치 bfs 돌림
			if (flag) {									// flag가 true일 때는 탈출에 성공한 경우임으로 
				System.out.println(time);				// 시간 출력해주고 리턴
				return;
			}
		}
	}

	static void water() {
		int size = water.size();
		for(int i=0;i<size;i++) {
			Point t = water.poll();
			for (int j = 0; j < 4; j++) {
				int nx = t.x + dx[j];
				int ny = t.y + dy[j];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c)
					continue;
				if (map[nx][ny] == '.') {			// .(빈 곳)일 때 물으로 바꿔주기
					map[nx][ny] = '*';
					water.add(new Point(nx, ny));	// 새로 물이 찼으니까 물 큐에 추가해주기
				}
			}
		}
	}

	static void hedgehog() {
		int size = hedgehog.size();
		for (int k = 0; k < size; k++) {
			Point t = hedgehog.poll();
			for (int i = 0; i < 4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c)
					continue;
				if (map[nx][ny] == 'D') {					// 비버 굴에 도달했다면 
					hedgehog.offer(new Point(ny, nx));		// 고슴도치 큐에 넣어주고
					flag = true;							// flag true로 만들어준 뒤 종료
					break;
				}
				if (map[nx][ny] == '.') {					// .(빈  곳)으로 S를 이동시켜주기
					map[nx][ny] = 'S';
					hedgehog.offer(new Point(nx, ny));		// 고슴도치 큐에 넣어주기
				}
			}
		}
	}
}
