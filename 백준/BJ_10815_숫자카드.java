package study_9월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드 {
	static int N, M, num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(binarySearch(num)) {
				System.out.print("1 ");
			}else System.out.print("0 ");
		}

	}

	static boolean binarySearch(int number) {
		int leftIdx = 0;
		int rightIdx = N - 1;
		while (leftIdx <= rightIdx) {
			int midIdx = (leftIdx + rightIdx) / 2;
			int mid = num[midIdx];

			if (number < mid)
				rightIdx = midIdx - 1;
			else if (number > mid)
				leftIdx = midIdx + 1;
			else
				return true;
		}
		return false;
	}
}
