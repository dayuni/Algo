package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889 {
	static int N, map[][], min = Integer.MAX_VALUE;
	static int start = 0, link = 0;
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		selected = new boolean[N+1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(1, 0);
		System.out.println(min);
	}

	static void comb(int idx, int depth) {
		if (depth == N / 2) {
			start=0;link=0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (selected[i] && selected[j])
						start += map[i][j];
					else if(!selected[i]&&!selected[j])
						link += map[i][j];
				}
			}
			int temp = Math.abs(start - link);
			if (min > temp)
				min = temp;
			return;
		}
		for (int i = idx; i <= N; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			comb(i+1, depth + 1);
			selected[i] = false;
		}
	}
}
