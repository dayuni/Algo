package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726 {
	static int n,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new int[n+1];
		arr[0]=1;
		arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1]+arr[i-2];
			arr[i] %= 10007;
		}
		System.out.println(arr[n]);
	}
}
