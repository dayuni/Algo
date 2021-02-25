package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(in.readLine());
			
			if(!pq.isEmpty()&&x==0)System.out.println(pq.poll());
			else if(pq.isEmpty()&&x==0)System.out.println(0);
			else {
				pq.offer(x);
			}
		}
	}
}
