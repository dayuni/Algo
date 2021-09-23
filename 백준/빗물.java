package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int h,w,arr[],sum=0,left=0,right=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new int[w];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<w;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<w-1;i++) {
			left = 0; right =0;
			for(int j=0;j<i;j++) {
				left = Math.max(left,arr[j]);
			}
			for(int j=i+1;j<w;j++) {
				right = Math.max(right, arr[j]);
			}
			if(arr[i]<left && arr[i]<right) {
				sum += Math.min(left, right) - arr[i];
			}
		}
		System.out.println(sum);
	}

}
