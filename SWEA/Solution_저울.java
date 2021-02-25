package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_저울 {
	static int N, total,ans;
	static int weight[];
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			total=0;
			ans =0;
			weight = new int[N];
			selected = new boolean[N];
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] =Integer.parseInt(st.nextToken());
				total += weight[i];
			}
			permutation(0,0,0,total);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void permutation(int idx, int lSum, int rSum, int remainder) {
		if(lSum>=rSum+remainder) {
			int cnt=1;
			for(int i=0;i<N-idx;i++)
				cnt*=2;
			for(int i=1;i<=N-idx;i++)
				cnt*=i;
			ans+=cnt;
	            return;
		}
		if (idx == N) { // 추를 모두 달았을 때
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			if(lSum>=rSum+weight[i]) // 왼쪽 저울의 총 합 >> 오른쪽 저울의 총 합 + 남은 무게의 합 
				permutation(idx+1,lSum,rSum+weight[i],remainder-weight[i]); // 오른쪽에 더 올릴 수 있음

			permutation(idx + 1,lSum+weight[i],rSum,remainder-weight[i]); // 왼쪽에 올릴 수 있음
			selected[i] = false;
		}
	}

}
