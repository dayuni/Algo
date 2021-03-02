package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427 {
	static String N;
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = in.readLine();
		int size = N.length();
		arr = new char[size];
		for(int i=0;i<size;i++) {
			arr[i] = N.charAt(i);
		}
		
		Arrays.sort(arr);
		
		for(int i=size-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}
}
