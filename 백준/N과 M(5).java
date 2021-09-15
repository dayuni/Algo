import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	static int arr[],out[],n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited= new boolean[n];
		out = new int[m];
		st = new StringTokenizer(in.readLine());	
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,m);
		System.out.println(sb.toString());
	}
	public static void dfs(int depth,int r) {
		if(depth==r) {
			for(int num : out) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				dfs(depth+1,r);
				visited[i]=false;
			}
		}
	}

}
