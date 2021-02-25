package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		int tmp[]=arr.clone();
		Arrays.sort(arr);
		int max = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			if(max!=arr[i]) {
				map.put(arr[i],idx++);
				max=arr[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(map.get(tmp[i])+" ");
		}
		System.out.println(sb);
	}
}
