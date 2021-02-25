package study_10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10974_모든순열 {
	static int n,numbers[],result[];
	static boolean selected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		numbers = new int[n];			// 1~n까지 숫자 저장할 배열 
		result = new int[n];			// 뽑은 숫자 저장할 배열
		selected = new boolean[n];		// 뽑았는지 안뽑았는지 확인
		
		for(int i=0;i<n;i++) {
			numbers[i]=i+1;				// 1~n으로 배열 채워줌
		}
		perm(0);						// 순열 돌리기 ~
	}
	static void perm(int cnt) {
		if(cnt==n) {					// cnt가 n이 되면 끝 !
			for(int i=0;i<n;i++) {				
				System.out.print(result[i]+" ");	// 순열 출력해주기 ~
			}
			System.out.println();				
			return;
		}
		for(int i=0;i<n;i++) {
			if(selected[i])continue;		// 이미 뽑은 숫자면 패쓰
			result[cnt]=numbers[i];			// 결과 배열에 뽑은 숫자 넣어주기
			selected[i]=true;				// 뽑았으니까 true로
			
			perm(cnt+1);					// 다음으로 ~
			selected[i]=false;				// 뽑았던거 다시 false로 돌려주기
		}
	}
}
