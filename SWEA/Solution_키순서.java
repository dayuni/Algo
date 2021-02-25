package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_키순서 {
	static int n,m,cnt;
	static boolean v[];
	static ArrayList<ArrayList<Integer>> start;
	static ArrayList<ArrayList<Integer>> end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++) {
			StringBuilder sb = new StringBuilder();
			n = Integer.parseInt(in.readLine())+1;
			m = Integer.parseInt(in.readLine());
			start = new ArrayList<>();
			end = new ArrayList<>();
			cnt = 0;

			for(int i=0;i<n;i++) {
				start.add(new ArrayList<>());
				end.add(new ArrayList<>());
			}
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				start.get(b).add(a);
				end.get(a).add(b);
			}
			for(int i=1;i<n;i++) {
				bfs(i);
			}
			sb.append("#").append(t).append(" ").append(cnt);
			System.out.println(sb.toString());
			
		}
	}

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		v = new boolean[n];
		int count=0;
		q.offer(num);
		v[num]=true;
		count++;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<start.get(now).size();i++) {
				int t = start.get(now).get(i);
				if(!v[t]) {
					q.offer(t);
					v[t]=true;
					count++;
				}
			}
		}
		
		q.offer(num);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<end.get(now).size();i++) {
				int t = end.get(now).get(i);
				if(!v[t]) {
					q.offer(t);
					v[t]=true;
					count++;
				}
			}
		}
		
		if(count==n-1)cnt++;
		
	}

}
/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
*/
