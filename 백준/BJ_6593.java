package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593 {
	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int l, r, c;
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static char map[][][];
	static boolean flag;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			 if(!st.hasMoreTokens())
	         st = new StringTokenizer(in.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (l == 0 && r == 0 && c == 0)
				break;
			map = new char[l][r][c];
			flag=false;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = in.readLine();
					if(str.equals(""))
						str=in.readLine();
					for (int k = 0; k < c; k++) {
						map[i][j][k] = str.charAt(k);
						if (map[i][j][k] == 'S')
							q.offer(new Point(i, j, k));
					}
				}
			}
			int time=0;
			while(true) {
				time++;
				if(q.size()==0) {
					System.out.println("Trapped!");
					break;
				}
				bfs();
				if(flag) {
					System.out.println("Escaped in "+time+" minute(s).");
					break;
				}
			}
			while(!q.isEmpty()) {
				q.poll();
			}
		}
	}

	static void bfs() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Point t = q.poll();
			for (int j = 0; j < 6; j++) {
				int nx = t.x + dx[j];
				int ny = t.y + dy[j];
				int nz = t.z + dz[j];
				if (nx < 0 || nx >= l || ny < 0 || ny >= r || nz < 0 || nz >= c)
					continue;
				if (map[nx][ny][nz] == 'E') {
					q.offer(new Point(nx, ny, nz));
					flag = true;
					break;
				}
				if (map[nx][ny][nz] == '.' ) {
					map[nx][ny][nz] = 'S';
					q.offer(new Point(nx, ny, nz));
				}

			}
		}

	}
}
