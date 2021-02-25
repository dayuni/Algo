package study_10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {
	static int n,s,cnt,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		cnt=0;
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0); 
		
		if(s==0) {		// s가 0인 경우는 아무것도 뽑지 않는 경우도 포함됨 
			cnt--;		// 1개 빼주기 !ㅁ
			System.out.println(cnt);
		}else
			System.out.println(cnt);
		
		
	}
	static void dfs(int idx,int num) {
		if(idx==n) {			// idx 마지막 위치가 될 때
			if(num==s)cnt++;	// 숫자의 합이 s와 같을 때 cnt 증가
			return;
		}
		
		dfs(idx+1,num+arr[idx]);	// 지금 위치의 숫자를 선택하는 경우
		dfs(idx+1,num);				// 선택하지 않는 경우
	}
}
