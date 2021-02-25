package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최적경로 {
	static int N, map[][], min;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			map = new int[N + 2][2];
			visited = new boolean[N+2];
			st = new StringTokenizer(in.readLine());
			map[0][0] = Integer.parseInt(st.nextToken()); // 회사
			map[0][1] = Integer.parseInt(st.nextToken());
			map[N + 1][0] = Integer.parseInt(st.nextToken()); // 집
			map[N + 1][1] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) { // 고객
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			perm(0,0,0);
			System.out.println("#"+t+" "+min);
		}
	}

	static void perm(int depth, int idx, int sum) {
		if(sum>=min)
			return;
		if (depth == N) {
			sum+=Math.abs(map[idx][0]-map[N+1][0])+Math.abs(map[idx][1]-map[N+1][1]);
			if (min > sum)
				min = sum;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm(depth+1,i,sum + Math.abs(map[idx][0]-map[i][0])+Math.abs(map[idx][1]-map[i][1]));
			visited[i] = false;
		}
	}
}
