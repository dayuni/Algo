package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_탈주범검거 {
	static int n,m,r,c,l,map[][];
	static int v[][];
	static String[] type= {
			null,
			"0312", //1
			"03",	//2
			"12",	//3
			"02",	//4
			"32",	//5
			"31",	//6	
			"01"	//7
	};
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer( in.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			v = new int[n][m];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					v[i][j]=Integer.MAX_VALUE;
				}
			}
			dfs(r,c,1);
			sb.append("#").append(t).append(" ").append(getCount()).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int x, int y, int time) {
		
		v[x][y]=time;
		if(time==l) return;
		
		String info = type[map[x][y]];
		int dir,nx,ny;
		for(int d = 0;d<info.length();d++) {
			dir = info.charAt(d)-'0';
			nx = x +dx[dir];
			ny = y +dy[dir];
			if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!=0
					&&type[map[nx][ny]].contains(Integer.toString(3-dir))
					&&v[nx][ny]>time) {
				dfs(nx,ny,time+1);
			}
				
		}
		
	}
	private static int getCount() {
		int count =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(v[i][j]!=Integer.MAX_VALUE) ++count;
			}
		}
		return count;
	}
}

