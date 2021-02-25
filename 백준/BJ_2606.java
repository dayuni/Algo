package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606 {
	static int N,V,arr[][],cnt=0;
	static boolean v[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		V = Integer.parseInt(in.readLine());
		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		bfs(1);
		System.out.println(cnt);
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		v[start]=true;

		while(!q.isEmpty()) {
			int n = q.poll();
			for(int i=1;i<arr.length;i++) {
				if(arr[n][i]==1&&!v[i]) {
					q.offer(i);
					v[i]=true;
					cnt++;
				}
			}
		}
	}
}
