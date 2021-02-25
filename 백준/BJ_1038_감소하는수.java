package study_9월_1주차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1038_감소하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N > 1022) { // 9876543210(1022번째 감소하는 수) 보다 크면 감소하는 수 없음 
			System.out.println(-1);
		} else if (N < 10) { // 10까지는 그 수 그대로 출력
			System.out.println(N);
		} else {
			Queue<Long> q = new LinkedList<>();
			int cnt = 0;
			for(int i=1;i<10;i++) {
				q.offer(new Long(i));
				cnt++;
			}
			while (cnt<N) {
				long num = q.poll();
				long temp = num%10;
				for(int i=0;i<temp;i++) {
					q.offer(num*10+i);
					cnt++;
					if(cnt==N) {
						System.out.println(num*10+i);
						break;
					}
				}
			}
		}
	}

}
