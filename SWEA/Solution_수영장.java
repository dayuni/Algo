package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수영장{
	static int price[],month[],total;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			price = new int[4];
			month = new int[13];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			} 
			total = price[3];
			dfs(1,0);
			
			System.out.println("#"+t+" "+total);
		}
	}
	static void dfs(int m, int sum) {
		if(m==13) {
			total = Math.min(total, sum);
			return;
		}
		if(month[m]==0) dfs(m+1,sum);
		if(month[m]>0) dfs(m+1,sum+month[m]*price[0]);
		dfs(m+1,sum+price[1]);
		if(m<=10)dfs(m+3,sum+price[2]);
		
	}
}