package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2503 {
	static int N, next;
	static int strike, ball;
	static String num[] = new String[3];
	static ArrayList<Integer> list = new ArrayList<>(987);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			
			String str[] = in.readLine().split(" ");
			// 숫자를 각 자리 수로 쪼개서 string 배열에 담아줌 
			num[0] = str[0].charAt(0) + "";
			num[1] = str[0].charAt(1) + "";
			num[2] = str[0].charAt(2) + "";
			
			strike = Integer.parseInt(str[1]);
			ball = Integer.parseInt(str[2]);

			next++;

			check(num);

		}
		System.out.println(list.size());

	}

	private static void check(String[] check) {
		// 비교할 수를 넣어줄 배열 
		ArrayList<Integer> tmp = new ArrayList<>();

		for (int k = 123; k < 988; k++) {
			int S = 0;
			int B = 0;

			int first = k / 100;								// 백의 자리
			int second = ((k - (first * 100)) / 10);			// 십의 자리
			int third = (k - (first * 100) - (second * 10));	// 일의 자리
			
			
			if (first == 0 || second == 0 || third == 0 || first == second || first == third || third == second)
			// 숫자가 0이거나, 같은 수가 나왔을 때는 continue
				continue;
			int[] arr = { first, second, third };
			// 각 자리수별로 숫자 넣어줌
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i] == Integer.parseInt(check[j])) { // check와 각자리를 비교 
						if (i == j) {							// 인덱스까지 같다면
							S++;								// 스트라이크
							continue;
						}										// 같은 숫자가 있다면 볼
						B++;
					}
				}
			}

			if (strike == S && ball == B) {		// 스트라이크와 볼의 개수가 같을 때 tmp에 그 숫자 넣어줌
				tmp.add(k);
			}
		}

		if (next != 1) {			// 그 다음부터는 겹치지 않는 것만 리스트에 넣어줌
			list.retainAll(tmp);
		} else						// 첫 턴일 때 tmp의 모든 숫자를 리스트에 넣음
			list.addAll(tmp);

	}

}
