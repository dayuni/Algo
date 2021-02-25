package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_요리사 {
	static int N, min,ans;
	static int numbers[];
	static int food[][];
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {

			StringBuilder sb = new StringBuilder();
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			selected = new boolean[N];
			food = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0,0);
			sb.append("#").append(t).append(" ").append(ans);
			System.out.println(sb.toString());
		}
	}

	public static void combination(int idx, int n) {// cnt 현재까지 뽑은 조합 개수
		if (idx >= N) {
			return;
		}
		if (n == N / 2) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (selected[i])
					A.add(i);
				else
					B.add(i);
			}
			int aSum = 0, bSum = 0;
			int aSize = A.size();
			for (int i = 0; i < aSize-1; i++) {
				for (int j = i+1; j < aSize; j++) {
					aSum += food[A.get(i)][A.get(j)];
					aSum += food[A.get(j)][A.get(i)];
					bSum += food[B.get(i)][B.get(j)];
					bSum += food[B.get(j)][B.get(i)];
				}
			}
			 ans = Math.min(ans, Math.abs(aSum - bSum));
			return;
		}
		selected[idx] = true;
		combination(idx + 1, n + 1);
		selected[idx] = false;
		combination(idx + 1, n);
	}
}
