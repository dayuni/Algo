package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(in.readLine());
			int arr[][]=new int[N][N];
			int sum=0;
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine());
				String tmp=st.nextToken();
				for(int j=0;j<N;j++) {
					arr[i][j]=tmp.charAt(j)-'0';
				}
			}

			for(int i=N/2;i>=0;i--) {
				for(int j=i;j<N-i;j++) {
					sum+=arr[i][j];
				}
			}
			for(int i=1;i<=N/2;i++) {
				for(int j=i;j<N-i;j++) {
					sum+=arr[i][j];
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
		
	}
}
