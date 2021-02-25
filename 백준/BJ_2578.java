package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578 {
	static int my[][],check[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		my = new int[5][5];

		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<5;j++) {
				my[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		loop:
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<5;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(checkBinggo(n)>=3) {
					System.out.println((5*i)+(j+1));
					break loop;
				}
			}
		}
		
	}
	
	static int checkBinggo(int n) {
		int sum=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(my[i][j]==n)my[i][j]=0;
			}
		}
		
		for(int i=0;i<5;i++) {
			boolean binggo = true;
			for(int j=0;j<5;j++) {
				if(my[i][j]>0)
					binggo=false;
			}
			if(binggo)sum++;
		}
		for(int i=0;i<5;i++) {
			boolean binggo = true;
			for(int j=0;j<5;j++) {
				if(my[j][i]>0)
					binggo=false;
			}
			if(binggo)sum++;
		}
		
		boolean binggo = true;
		for(int i=0;i<5;i++) {
			if(my[i][i]>0)binggo=false;
		}
		if(binggo)sum++;
		
		binggo = true;
		for(int i=0;i<5;i++) {
			if(my[4-i][i]>0)binggo=false;
		}
		if(binggo)sum++;
		
		return sum;
	}
}
