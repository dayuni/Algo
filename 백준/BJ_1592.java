package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int count=0;
		int cur =0;
		while(true) {
			arr[cur]++;
			if(arr[cur]==M)break;
			if(arr[cur]%2==1) {
				if((cur-L)<0)
					cur = N-L+cur;
				else cur -=L;				
			}else if(arr[cur]%2==0) {
				if(cur+L>=N) {
					cur=L-N+cur;
				}else
					cur+=L;
			}

			count++;
		}	
		System.out.println(count);
	}
}
