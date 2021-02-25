package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309 {
	static int arr[],sum;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(in.readLine());
			sum+=arr[i];
		}
		loop:
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(i==j)continue;
				if(sum-arr[i]-arr[j]==100) {
					arr[i]=0;
					arr[j]=0;
					break loop;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i=0;i<9;i++) {
			if(arr[i]!=0)
				System.out.println(arr[i]);
		}
	}

}
