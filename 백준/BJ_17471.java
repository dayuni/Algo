package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17471 {
	static int N, people[];
	static class Link{
		int people;
		int num;
		int to[];
		public Link(int people,int num, int[] to) {
			super();
			this.people = people;
			this.num = num;
			this.to = to;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Link> list = new ArrayList<>();
		N = Integer.parseInt(in.readLine()); // 구역의 개수
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int p=Integer.parseInt(st.nextToken()); // 1번~N번 인구 수
			list.add(new Link(p,0,null));
		}
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(in.readLine());
			int num=Integer.parseInt(st.nextToken());
			list.get(i).num = num;
			list.get(i).to=new int[num];
			for(int j=0;j<num;j++) {
				int to=Integer.parseInt(st.nextToken());
				list.get(i).to[j]=to;
			}
		}

	}
}
