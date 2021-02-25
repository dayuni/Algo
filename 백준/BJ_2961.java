package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961 {
	private static int N;
	private static int min;
	private static int flavor[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		flavor = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		comb(0, 0, 1, 0);
		System.out.println(min);

	}

	static void comb(int cnt, int select, int mul, int sum) {
		if (select >= 1) {
			int result = Math.abs(mul - sum);
			min = min > result ? result : min;
		}
		if (cnt == N)return;
		// 현재 수부터 끝수까지 시도
		comb(cnt + 1, select + 1, mul * flavor[cnt][0], sum + flavor[cnt][1]);
		comb(cnt + 1, select, mul, sum);
	}
}
