package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5515 {
	static int M,D,pass,Fri=4;
	static int[] days= {31,29,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			pass=0;
			
			for(int i=1;i<M;i++) {
				pass+=days[i-1];
			}
			pass+=D-1;
			int Day=(pass+Fri)%7;
			System.out.println("#"+t+" "+Day);
		}
		
	}
}
