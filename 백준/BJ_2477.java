package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2477 {
	static class Point {
		int dir;
		int len;

		public Point(int dir, int len) {
			super();
			this.dir = dir;
			this.len = len;
		}

	}

	static int N;
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list.add(new Point(dir, len));
		}
		int area =0;
		int point =0;
		for (int i = 0; i < 6; i++) {
			if(area<list.get(i).len*list.get((i+1)%6).len) {
			area=list.get(i).len*list.get((i+1)%6).len;
			point = i;
		}}
		int small =0;
		small = list.get((point+3)%6).len*list.get((point+4)%6).len;
		area = area- small;
		System.out.println(N*area);
	}
}
