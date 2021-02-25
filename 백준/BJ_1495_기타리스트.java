package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1495_기타리스트 {
	static int N, S, M, V[], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 연주할 곡 개수
		S = Integer.parseInt(st.nextToken()); // 시작 볼륨
		M = Integer.parseInt(st.nextToken()); // 최대 볼륨
		V = new int[N];
		dp = new int[N][M + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		if (S + V[0] <= M)
			dp[0][S + V[0]] = 1;
		if (S - V[0] >= 0)
			dp[0][S - V[0]] = 1;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= M; j++) {
				if (dp[i - 1][j] == 1) {
					if (j + V[i] <= M) {
						dp[i][j + V[i]] = 1;
					}
					if (j - V[i] >= 0) {
						dp[i][j - V[i]] = 1;
					}
				}
			}
		}
		System.out.println(getMax());
	}

	static int getMax() {
		for (int i = M; i >= 0; i--) {
			if (dp[N - 1][i] == 1) {
				return i;
			}
		}
		return -1;
	}
}
