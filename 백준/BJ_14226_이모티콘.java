package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14226_이모티콘 {
	static int S;
	static class Node{
		int E,C,cnt;

		public Node(int E, int C, int cnt) {
			super();
			this.E = E;
			this.C = C;
			this.cnt = cnt;
		}
		
	}
	static boolean[][] visited; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(in.readLine());
		visited = new boolean[2002][2002]; // [이모티콘][클립보드]
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(1,0,0));
		visited[1][0]=true;
		
		while(!q.isEmpty()) {
			Node t = q.poll();
			int e = t.E;
			int c = t.C;
			int cnt = t.cnt;
			if(e == S) {
				System.out.println(cnt);
				break;
			}
			if(!visited[e][e]) { // 복사
				visited[e][e]=true;
				q.offer(new Node(e,e,cnt+1));
			}
			if(c!=0&&!visited[e+c][c]&&e+c<=1000) { // 붙여넣기
				visited[e+c][c]=true;
				q.offer(new Node(e+c,c,cnt+1));
			}
			if(e>0&&!visited[e-1][c]) { // 삭제
				visited[e-1][c]=true;
				q.offer(new Node(e-1,c,cnt+1));
			}
		}
		
	}
}
