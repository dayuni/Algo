package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491 {
	static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		int len = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] <= arr[i])
				len++;
			else
				len = 1;
			if (len > max)
				max = len;
		}
		len = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] >= arr[i])
				len++;
			else
				len = 1;
			if (len > max)
				max = len;
		}

		System.out.println(max);
	}
}
