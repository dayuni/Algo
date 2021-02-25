package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14696 {
	static int N, aCard[][], bCard[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		aCard = new int[N][4];
		bCard = new int[N][4];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			for (int a = 0; a < A; a++) {
				int card = Integer.parseInt(st.nextToken());
				aCard[i][card - 1]++;
			}

			st = new StringTokenizer(in.readLine());
			int B = Integer.parseInt(st.nextToken());
			for (int b = 0; b < B; b++) {
				int card = Integer.parseInt(st.nextToken());
				bCard[i][card - 1]++;
			}
			if (aCard[i][3] > bCard[i][3]) {
				System.out.println("A"); // 별 개수 다를 때
			} else if (aCard[i][3] < bCard[i][3]) {
				System.out.println("B");
			} else if ((aCard[i][3] == bCard[i][3])) { // 별 개수 같고
				if (aCard[i][2] > bCard[i][2]) { // 동그라미 개수 다를 때
					System.out.println("A");
				} else if (aCard[i][2] < bCard[i][2]) {
					System.out.println("B");
				} else if ((aCard[i][2] == bCard[i][2])) { // 별,동그라미 개수 같을 때
					if (aCard[i][1] > bCard[i][1]) {
						System.out.println("A");
					} else if (aCard[i][1] < bCard[i][1]) {
						System.out.println("B");

					} else if (aCard[i][1] == bCard[i][1]) {
						if (aCard[i][0] > bCard[i][0]) {
							System.out.println("A");
						} else if (aCard[i][0] < bCard[i][0]) {
							System.out.println("B");
						}

						else {
							System.out.println("D");
						}
					}

				}

			}
		}
	}
}