package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567 {
	static int N, arr[][];
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++)
					arr[j][k] = 1;
			}
		}
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				if(arr[i][j]==1) {
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=1&&nx<=100&&ny>=1&&nx<=100&&arr[nx][ny]==0)sum++;
						else if(nx<1||nx>100||ny<1||ny>100)
							sum++;
					}
				}
			}
		}
		System.out.println(sum);

	}
}
