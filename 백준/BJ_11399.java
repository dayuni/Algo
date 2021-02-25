package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int min = 0;
		for(int i=0;i<N;i++) {
			sum += arr[i];
			min += sum;
		}
		
		System.out.println(min);
	}
}
