package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918 {
	static char map[][];
	static int R,C,N,sec=1;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static class Bomb{
		int x , y;

		public Bomb(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static Queue<Bomb> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='O') {
					q.offer(new Bomb(i,j));// 폭탄 초기 리스트 저장
				}
			}
		}
		
		while(true) {
			if(sec==N)break;
			makeBomb();
			sec++;
			if(sec==N)break;
			deleteBomb();
			sec++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	// 폭탄 설치
	static void makeBomb() {
		// 모든 칸에 폭탄 설치 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='.')
					map[i][j]='O';
			}
		}
		
	}
	// 폭탄 폭발
	static void deleteBomb() {
		
		while(!q.isEmpty()) {
			Bomb b = q.poll();
			map[b.x][b.y]='.';
			for(int k=0;k<4;k++) {
				int nx = b.x+dx[k];
				int ny = b.y+dy[k];
				if(nx>=0&&nx<R&&ny>=0&&ny<C) {
					map[nx][ny]='.';
				}
			}
		}
		
		// 폭탄 큐에 넣어줌
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='O')
					q.offer(new Bomb(i,j));
			}
		}
		
	}
}
