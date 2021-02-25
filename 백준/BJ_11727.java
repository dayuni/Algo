package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727 {
	static int n,d[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		d = new int[n+1];
		d[0]=1;
		d[1]=1;
		
		for(int i=2;i<=n;i++) {
			d[i]=d[i-1]+2*d[i-2];
			d[i]%=10007;
			
		}
		System.out.println(d[n]);
	}
}
