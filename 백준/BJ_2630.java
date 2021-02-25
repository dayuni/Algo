package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2630 {
	static int arr[][];
	static int N,B,W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		count(N,0,0);
		System.out.println(W);
		System.out.println(B);
		
	}
	static void count(int n,int x,int y) {
		if(isSame(n,x,y)) {
			if(arr[x][y]==0)W++;
			else B++;
			return;
		}
		count(n/2,x,y);
		count(n/2,x+n/2,y);
		count(n/2,x,y+n/2);
		count(n/2,x+n/2,y+n/2);
	}
	static boolean isSame(int n,int x, int y) {
		int pre = arr[x][y];
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(pre!=arr[i][j])return false;
			}
		}
		return true;
	}
}
