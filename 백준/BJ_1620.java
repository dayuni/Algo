package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map<String,String> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			String num = Integer.toString(i+1);
			map.put(str,num);
			map.put(num,str);
		}
		for(int i=0;i<M;i++) {
			String str = in.readLine();
			System.out.println(map.get(str));
		}
	}
}
