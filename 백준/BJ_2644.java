package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644 {
	static int n, p1, p2;
	static int arr[][];
	static boolean visited[];
	static int total[];
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine()); // 사람의 수
		arr = new int[n + 1][2];
		visited = new boolean[n + 1];
		total = new int[n + 1];

		st = new StringTokenizer(in.readLine());
		p1 = Integer.parseInt(st.nextToken()); // 촌수 계산할 첫번째 사람
		p2 = Integer.parseInt(st.nextToken()); // 촌수 계산할 두번째 사람

		int m = Integer.parseInt(in.readLine());

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 부모
			arr[i][1] = Integer.parseInt(st.nextToken()); // 자식
		}

		System.out.println(bfs(p1, n));
	}

	public static int bfs(int p1, int N) {
		q.offer(p1);
		while (!q.isEmpty()) {
			int p = q.poll();
			visited[p] = true;
			for (int i = 0; i < N; i++) {
				if (arr[i][0] == p1 && !visited[arr[i][1]]) {
					q.add(arr[i][1]);
					total[arr[i][1]] = total[arr[i][0]] + 1;
				} else if (arr[i][1] == p && !visited[arr[i][0]]) {
					q.add(arr[i][0]);
					total[arr[i][0]] = total[arr[i][1]] + 1;
				}

			}
			if (!q.isEmpty() && q.peek() == p2) {
				return total[p2];
			}
		}
		return -1;
	}
}
