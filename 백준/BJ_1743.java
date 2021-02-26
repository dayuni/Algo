package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1743 {
	static int N,M,K,arr[][],cnt;
	static boolean[][] v;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];	// 좌표값이 1부터 시작해서 N+1,M+1 크기로 
		v = new boolean[N+1][M+1];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;	// 음식물이 있는 곳 1으로 채워준다
			
		}
		
		int max =0;				
		for(int i=1;i<=N;i++) {			// 1부터 시작
			for(int j=1;j<=M;j++) {
				cnt =1;					// cnt값 초기화
				if(!v[i][j]&&arr[i][j]==1) { // 방문하지 않고, 1인곳부터 dfs 시작
					int tmp = dfs(i,j);		 // dfs 후 cnt값저장
					if(tmp>max)	
						max = tmp;			// 최대값 저장
				}
			}
		}
		System.out.println(max);
		
	}
	static int dfs(int x, int y) {
		v[x][y]=true;
		for(int i=0;i<4;i++) {			// 사방탐색
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>N||ny<0||ny>M) continue; // 범위 벗어나면 continue
			if(!v[nx][ny]&&arr[nx][ny]==1) { // 방문하지 않고, 1인 곳으로 dfs 다시시작, cnt증가
				dfs(nx,ny);
				cnt++;
			}
		}
		return cnt;
	}
}
