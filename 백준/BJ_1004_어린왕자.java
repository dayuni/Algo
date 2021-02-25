package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1004_어린왕자 {
	static int N, point[][], cnt;
	static Circle[] circle;
	static class Circle {
		int x;
		int y;
		int r;

		public Circle(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			point = new int[2][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			point[0][0] = Integer.parseInt(st.nextToken()); // 출발점 x 
			point[0][1] = Integer.parseInt(st.nextToken());	// 출발점 y
			point[1][0] = Integer.parseInt(st.nextToken());	// 도착점 x
			point[1][1] = Integer.parseInt(st.nextToken());	// 도착점 y
			
			N = Integer.parseInt(in.readLine()); // 행성계 개수
			cnt =0;
			circle = new Circle[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken()); // 행성 x
				int y = Integer.parseInt(st.nextToken()); // 행성 y
				int r = Integer.parseInt(st.nextToken()); // 행성 반지름
				
				circle[i]=new Circle(x,y,r);
			}
			
			for(int i=0;i<N;i++) {
				// 행성의 중심과 출발점과의 거리
				double startD = EucDist(point[0][0],point[0][1],circle[i].x,circle[i].y);
				double endD = EucDist(point[1][0],point[1][1],circle[i].x,circle[i].y);
				// 행성을 통과해야 하는 경우 : 출발점과 도착점 중 한가지만 행성의 내부에 존재할 때 
				// 둘 다 행성의 내부거나 둘 다 외부이면 행성을 지나지 않아도 됨
				// 중심과의 거리가 행성의 반지름 보다 작을 때  숫자를 세줌
				boolean start=false,end=false;
				if(startD<circle[i].r&&endD>circle[i].r) {
					// 출발점만 행성 내부 
					cnt++;
				}			
				else if(startD>circle[i].r&&endD<circle[i].r) {
					// 도착점만 행성 내부
					cnt++;
				}
				
			}
			System.out.println(cnt);
		}
	}

	// x의 차 제곱 + y의 차 제곱을 구하고 루트를 씌우면 유클리디안 거리가 된다.
	static double EucDist(int x, int y, int cx, int cy) {

		double temp = Math.pow((double) x - (double) cx, 2) + Math.pow((double) y - (double) cy, 2);
		return Math.sqrt(temp);
	}
}
