package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644 {
	static int n, p1, p2, m, cnt = 0;
	static int arr[][],res[];
	static boolean v[];
	
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine()); // 사람의 수
		arr = new int[n+1][n+1];			 // 인접행렬 이용
		res = new int[n+1];					 // 촌수를 체크할 배열
		v = new boolean[n + 1];				 // 방문 체크
		st = new StringTokenizer(in.readLine());
		p1 = Integer.parseInt(st.nextToken()); // 촌수 계산할 첫번째 사람
		p2 = Integer.parseInt(st.nextToken()); // 촌수 계산할 두번째 사람

		m = Integer.parseInt(in.readLine());

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()); // 부모
			int b = Integer.parseInt(st.nextToken()); // 자식
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		bfs(p1,p2);
		
		if(res[p2]==0)System.out.println(-1);
		else System.out.println(res[p2]);
		System.out.println();

	}

	static void bfs(int a, int b) {
		q.offer(a);
		v[a] = true;
		while (!q.isEmpty()) {
			int num = q.poll();
			if(num==b) return;				// b에 도착하면 끝
			for(int i=1;i<=n;i++) {
				if(arr[num][i]==1&&!v[i]) { // 행렬의 값이 1이고 방문하지 않은 곳
					q.offer(i);
					v[i]=true;
					res[i]=res[num]+1;		// 촌수를 +1 
				}
			}
		}
	}

}
