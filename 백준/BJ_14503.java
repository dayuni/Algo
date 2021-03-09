package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14503 {
	static int N,M;
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int map[][];
	static int cnt = 0;
	static boolean v[][];
	static class Robot{
		int x,y,dir;

		public Robot(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		
		map = new int[N][M];
		v = new boolean[N][M];
		st = new StringTokenizer(in.readLine());
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Clean(robotX,robotY,dir);
		Count();
		System.out.println(cnt);
		
	}
	private static void Clean(int robotX, int robotY, int dir) {
		Queue<Robot> q = new LinkedList<>();
		v[robotX][robotY] = true;
		q.offer(new Robot(robotX,robotY,dir));
		
		while(!q.isEmpty()) {
			Robot r = q.poll();
			int nowX = r.x;
			int nowY = r.y;
			int nowD = r.dir;
			int nextX,nextY,nextD;
			Boolean check = false;
			for(int i=0;i<4;i++) {
				
				nowD = (nowD+3) % 4;			// (현재 방향 + 3) % 4 -> 다음 방향
				nextX = nowX + dx[nowD];		// 현재 방향 기준으로 다음 X
				nextY = nowY + dy[nowD];		// 현재 방향 기준으로 다음 Y

				if(nextX<0||nextX>=N||nextY<0||nextY>=M) continue;
				
				if(map[nextX][nextY]==0&&!v[nextX][nextY]) {	// 다음 위치가 0이면서 방문 X 일 때 
					v[nextX][nextY]=true;
					q.offer(new Robot(nextX,nextY,nowD));		
					check=true;									
					break;
				}
			}
			if(!check) {									// false면 네 방향 다 방문 완료
				nextD = (nowD+2)%4;							// 후진할 방향
				nextX = nowX + dx[nextD];
				nextY = nowY + dy[nextD];
				
				if(map[nextX][nextY]==0) {					// 후진한곳이 0이면 탐색 마저 진행
					v[nextX][nextY]=true;					// 아니면 그대로 탐색 끝
					q.offer(new Robot(nextX,nextY,nowD));
				}
			}
		}
	}
	private static void Count() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0&&v[i][j])					// 0이면서 방문한 곳 
					cnt++;
			}
		}
	}

}
