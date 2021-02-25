package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163 {
	static int N,arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		arr = new int[101][101];
		int ans[]=new int[N];
		
		for(int k=1;k<=N;k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int i=x;i<x+w;i++) {
				for(int j=y;j<y+h;j++) {
					arr[i][j]=k;
				}
			}
			
		}
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(arr[i][j]!=0) {
					ans[arr[i][j]-1]++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			if(ans[i]!=0)
				System.out.println(ans[i]);
		}
	}
}
