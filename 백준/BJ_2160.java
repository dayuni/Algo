package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2160 {
	static int N;
	static int arr[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		arr = new int[N][5][7];
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(in.readLine());
				String token = st.nextToken();
				for (int j = 0; j < 7; j++) {
					arr[k][i][j] = token.charAt(j);
				}
			}
		}
		int cnt = 0;
		int min = Integer.MAX_VALUE, a = 0, b = 0;
		for (int k = 0; k < N; k++) {
			for (int l = k + 1; l < N; l++) {
				cnt = 0;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 7; j++) {
						if (arr[k][i][j] != arr[l][i][j]) {
							cnt++;
						}

					}
				}
				if (cnt < min) {
					min = cnt;
					a=k+1;
					b=l+1;
				}
			}
		}
		System.out.println(a+" "+b);
	}
}
