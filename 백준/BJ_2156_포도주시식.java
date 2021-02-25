package study_9월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2156_포도주시식 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		if (n >= 1) // n이 1이면 제일 첫번째 
			dp[0] = arr[0];
		if (n >= 2) // 2면 첫번째,두번째 
			dp[1] = arr[0] + arr[1];
		if (n >= 3) // 3일땐 1,2를 먹은 경우 / 1,3을 먹은 경우 / 2,3,을 먹은 경우 중에 가장 큰 수 
			dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}

		System.out.println(dp[n - 1]);

	}
}
