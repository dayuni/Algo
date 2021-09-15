import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	static int arr[],output[],n,max=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[n];
		visited= new boolean[n];
		output = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,n);
		System.out.println(max);
		
	}
	public static void dfs(int depth, int r) {
		if(depth==r) {
			int sum = 0;
			for(int i=0;i<n-1;i++) {
				sum += Math.abs(output[i]-output[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				dfs(depth+1,r);
				visited[i]=false;
			}
		}
	}

}
