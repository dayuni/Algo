package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(in.readLine());
			TreeMap<Integer,Integer> map = new TreeMap<>();
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				char C = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				switch(C) {
				case 'I':
					if(!map.containsKey(n))
						map.put(n,1);
					else {
						map.put(n,map.get(n)+1);						
					}
					break;
				case 'D':
					if(map.isEmpty())continue;
					
					if(n==1) {
						int max = map.lastKey();
						if(map.get(max)-1==0) {
							map.remove(max);
						}else {
							map.put(max,map.get(max)-1);
						}
					}
					if(n==-1){
						int min = map.firstKey();
						if(map.get(min)-1==0) {
							map.remove(min);
						}else {
							map.put(min,map.get(min)-1);
						}
					}
					break;
				}
			}
			if(map.isEmpty()) System.out.println("EMPTY");
			else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
		}
	}
}
