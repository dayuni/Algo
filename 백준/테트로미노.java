package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int n,m,arr[][];
	static int max = Integer.MIN_VALUE;
	static boolean visited[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dfs(i,j,0,0);
				special(i,j);
			}
		}

		System.out.println(max);
	}

	private static void special(int x, int y) {
		int point = 4;
		int min = Integer.MAX_VALUE;
		int sum = arr[x][y];
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(point<=2)return;
			if(nx<0||ny<0||nx>=n||ny>=m) {
				point--;
				continue;
			}
			min = Math.min(min, arr[nx][ny]);
			sum = sum+arr[nx][ny];
		}
		if(point==4) {
			sum = sum-min;
		}
		max = Math.max(max, sum);
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if(depth==4) {
			max = Math.max(max,sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m)continue;
			if(visited[nx][ny])continue;
			visited[nx][ny]=true;
			dfs(nx,ny,depth+1,sum+arr[nx][ny]);
			visited[nx][ny]=false;
		}
		
	}
	
}
