package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs=new HashSet<>();
		List<String> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			hs.add(in.readLine());
		}
		for(int i=0;i<M;i++) {
			String name = in.readLine();
			if(hs.contains(name)) {
				list.add(name);
			}
		}
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for(int i=0;i<size;i++) {
			System.out.println(list.get(i));
		}
	}
}
