package study_9월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
	static int N, C, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1; // 최소 거리
		int right = arr[N - 1] - arr[0]; // 최대 거리
		int dis = 0; // 간격
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2; 
			int start = arr[0]; // 첫번째 집부터 시작 
			int cnt = 1;

			for (int i = 1; i < N; i++) {
				dis = arr[i] - start; // 간격을 조정해가면서 
				if (dis >= mid) {	  // 간격이 기준값보다 크면
					cnt++;			  // 카운트 증가
					start = arr[i];	  // 집 위치 바꿔줌
				}
			}
			if (cnt >= C) {			  // 공유기 설치 개수가 C와 같거나 C보다 많으면
				ans = mid;			  // 답은 기준값 
				left = mid + 1;		  // 공유기 설치 불가능 -> 간격을 좁혀준다 
			} else {
				right = mid - 1;	  // 공유기 설치 더 해야함 -> 간격을 넓혀준다 
			}
		}
		System.out.println(ans);
	}

}
