package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780 {
	static int n;
	static int count[];
	static int paper[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		paper = new int[n][n];
		count = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cutPaper(0, 0, n);
		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}

	static boolean isSame(int x, int y, int size) {
		int temp = paper[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (temp != paper[i][j])
					return false;
			}
		}

		return true;
	}

	static void cutPaper(int x, int y, int size) {
		if (isSame(x, y, size)) {
			count[paper[x][y] + 1]++;
		} else {
			int newSize = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cutPaper(x + newSize * i, y + newSize * j, newSize);
				}
			}
		}
	}
}
