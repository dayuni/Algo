package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int m,n,arr[][],max;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					System.out.println(-1);
					return;
				}
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}

		System.out.println(max-1);
	}
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {		
					q.offer(new Point(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			int px = p.x;
			int py = p.y;
			for(int d=0;d<4;d++) {
				int nx = px+dx[d];
				int ny = py+dy[d];

				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				
				if(arr[nx][ny]==0||(arr[nx][ny]>arr[px][py]+1)){
					arr[nx][ny] = arr[px][py]+1;
					q.offer(new Point(nx,ny));
					
				}
			}
		}
		
	}
}
