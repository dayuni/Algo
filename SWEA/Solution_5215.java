package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5215 {
	static int max = 0;
	static int N, L;
	static int taste[];
	static int kcal[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			taste = new int[N]; // 맛 점수
			kcal = new int[N]; // 칼로리

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			max =0;
			
			powerSet(taste,kcal,new boolean[N],0); // 선택배열, idx 
			//comb(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}

	}

	private static void powerSet(int[] taste, int[] kcal, boolean[] sel, int idx) {
		if(idx==N) {
			int sum=0;
			ArrayList<Integer> list = new ArrayList<>();			
			for(int i=0;i<N;i++) {
				if(sel[i]) {
					sum+=kcal[i];
					list.add(i);
					if(sum>L) {
						return;
					}
				}
			}
			sum=0;
			for(int i=0;i<list.size();i++) {
				sum+=taste[list.get(i)];
			}
			max = Math.max(max, sum);
			return;
		}
		
		sel[idx]=true;
		powerSet(taste,kcal,sel,idx+1);
		sel[idx]=false;
		powerSet(taste,kcal,sel,idx+1);
	}

	static void comb(int cnt, int tSum, int kSum) {
		if (kSum > L) {
			return;
		}
		if (cnt == N) {
			int result = tSum;
			if (max < result)
				max = result;
			return;
		}

		comb(cnt + 1, tSum + taste[cnt], kSum + kcal[cnt]);
		comb(cnt + 1, tSum, kSum);
	}
	
	
}