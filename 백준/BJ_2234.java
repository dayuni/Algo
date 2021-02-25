package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2234 {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int n,m,map[][],max;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {-1,0,1,0};
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		v = new boolean[m][n];
		max = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!v[i][j]) {				// map을 돌면서 방문하지 않은곳이면 
					bfs(i,j);				// bfs를 돌리고 그 때 count 증가 ( 방 개수 )
					count++;
				}
			}
		}
		System.out.println(count);			// 방 개수
		System.out.println(max);			// 최대 방 크기
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				breakWall(i,j);				// 벽 뿌수기
			}
		}
		System.out.println(max);			// 벽 하나 뿌수고 최대 방 크기
	}

	private static void breakWall(int i, int j) {
		for(int k=0;k<4;k++) {						//사방확인 
			if((map[i][j]&(1<<k))>0) {				// k번째가 0보다 클 때 그 쪽에 벽이 있는거임
				for(int r=0;r<v.length;r++)			//	근데 사실 이건 잘 모르겠음 왜 false로 채우는건지 
					Arrays.fill(v[r],false);
				map[i][j]-=(1<<k);					// 벽이 있으니까 그 벽을 뿌수고 bfs 돌림
				bfs(i,j);
				map[i][j]+=(1<<k);					// 다음을 위해 이제 원래대로 돌려줌 
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> q=new LinkedList<>();	
		q.offer(new Point(x,y));
		v[x][y]=true;		
		int roomSize=0;						// 방 크기
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int wall = map[p.x][p.y];
			roomSize++;						// 큐에서 뽑는거 = 방 크기 체크해줌 
			for(int i=0;i<4;i++) {
				if((wall&(1<<i))>0)continue;	
				// i번재 원소를 가져오는 것, 1 오른쪽에 0이 i개 -> i번재 원소를 나타냄
				// & 연산으로 i번 원소가 1인지 0인지 확인한 것이 0보다 크다(벽이 있다면) continue
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if((nx>=0&&nx<m&&ny>=0&&ny<n)&&!v[nx][ny]) {	// 범위 안에 있으면서 방문하지 않은 곳
					v[nx][ny]=true;								// 방문처리
					q.offer(new Point(nx,ny));					// 큐에 넣기
				}							
			}
		}
		max = Math.max(max, roomSize);							// 방 최대 크기 구해주기
	}
}
