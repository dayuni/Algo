package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15685 {
	static int n;
	static boolean map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(in.readLine());
		map = new boolean[101][101];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			makeCurve(x,y,getDir(d,g));
		}
		System.out.println(squares());
	}
	private static int squares() {
		int cnt =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1])
					cnt++;
			}
		}
		return cnt;
	}
	private static void makeCurve(int x, int y,List<Integer> dirs) {
		map[x][y]=true;
		for(int dir : dirs) {
			if(dir==0)map[++x][y]=true;
			else if(dir==1)map[x][--y]=true;
			else if(dir==2)map[--x][y]=true;
			else if(dir==3)map[x][++y]=true;
		}
		
	}
	private static List<Integer> getDir(int d, int g) {
		List<Integer> dirs = new ArrayList<>();
		dirs.add(d);
		while(g!=0) {
			g--;
			for(int i=dirs.size()-1;i>=0;i--) {
				int direction = (dirs.get(i)+1)%4;
				dirs.add(direction);
			}
		}
		return dirs;
	}
	
	
}
