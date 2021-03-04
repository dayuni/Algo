package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11497 {
	static int T,N,arr[],res[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			res = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int left =0;
			int right = N-1;
			
			for(int i=0;i<N;i++) {			// 가장 큰 수를 가운데, 작은 순서부터 왼쪽 오른쪽 채워줌
				if(i%2!=0) {
					res[left]=arr[i];		// 왼쪽에 넣어줌
					left+=1;
				}
				else {
					res[right]=arr[i];		// 그 다음 수 오른쪽에 넣어줌
					right-=1;
				}
			}
			int min = Integer.MAX_VALUE;
			min = Math.abs(res[0]-res[N-1]);	// 첫번째와 마지막의 차이 구함
			
			for(int i=1;i<N;i++) {
				min = Math.max(min,Math.abs(res[i]-res[i-1]));	// 두번째부터 오른쪽과의 차이 구해서 가장 큰 것
			}
			System.out.println(min);
		}
		
		
	}
}

/*
1
5
2 4 5 7 9
 
*/