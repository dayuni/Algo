package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_활주로건설 {
	static int n, x, map[][],rmap[][], cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			cnt =0;
			map = new int[n][n];
			rmap=new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = rmap[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			process();
			System.out.println("#"+t+" "+cnt);
		}
		

	}

	static void process() {
		for (int i = 0; i < n; i++) {
			if (makeRoad(map[i]))cnt++;
			if (makeRoad(rmap[i]))cnt++;
		}
	}

	static boolean makeRoad(int[] road) {
		int beforeH, size;
		beforeH = road[0];
		size = 1;
		for (int j = 1; j < n; j++) {
			if (beforeH == road[j]) {
				size++;
			}else if(beforeH+1 == road[j]) {
				if(size<x)return false;
				beforeH++;
				size=1;
			}else if(beforeH-1==road[j]) {
				int c = 0;
				for(int k=j;k<n;k++) {
					if(road[k]!=beforeH-1)break;
						c++;
				}
				if(c<x)return false;
				j+=x-1;
				beforeH--;
				size=0;
			}else {
				return false;
			}
		}
		return true;

	}


}
