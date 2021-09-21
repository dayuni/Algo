package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int n,arr[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i,i,0);
		}
		System.out.println(min);
	}
	public static void dfs(int start, int now, int cost) {
		if(isVisited()) {    // 모든 도시를 다 방문했을 때
			if(arr[now][start]!=0) {
				min = Math.min(min,cost+arr[now][0]);
			}
			return;
		}
		for(int i=1;i<n;i++) {
			if(!visited[i]&&arr[now][i]!=0) { // 방문하지 않았으면서 갈 수 있을 때
				visited[i]=true;
				dfs(start,i,cost+arr[now][i]);
				visited[i]=false;
			}
		}
	}
	private static boolean isVisited() {  
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
	
	
}
