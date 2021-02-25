package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931 {
	static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int time[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1]= Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(time, new MyComparator());
		
		int count=0;
		int end =-1; 
		for(int i=0;i<N;i++) {
			if(time[i][0]>=end) { // 지금 시작 시간이 이전 종료 시간보다 늦을 때
				end=time[i][1]; // 종료 시간 바꿔주고 
				count++;
			}
		}
		System.out.println(count);
	}

}
