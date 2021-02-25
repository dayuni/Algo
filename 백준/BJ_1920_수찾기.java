package study10월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
	static int n,A[],m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<m;i++) {
			int b = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(A,b)>-1) {
				System.out.println("1");
			}else System.out.println("0");
		}
	}
}
