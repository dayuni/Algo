package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(in.readLine());
			int d[] = new int[11];
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;

			for (int i = 4; i <= n; i++) {
				d[i] = d[i - 1] + d[i - 2] + d[i - 3];
			}
			System.out.println(d[n]);
		}

	}
}
