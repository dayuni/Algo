package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2605 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1;i<N+1;i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(i-1-num,i);
		}
		for(int i=0;i<N;i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}
