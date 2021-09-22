package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0;i<n-1;i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
		
	}

}
