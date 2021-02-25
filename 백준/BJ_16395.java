package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16395 {
	static int arr[][],N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[31][31];
		arr[1][1]=1;
		
		for(int i=2;i<=N;i++) {
			arr[i][1]=1;
			for(int j=1;j<N;j++) {
				arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
			arr[i][N]=1;
		}
		System.out.println(arr[N][K]);
	}
}
