package BJ;


import java.io.*;
import java.util.*;
public class BJ_3190 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());
		int map[][] = new int[n][n];
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1]=2;
		}
		
		int l = Integer.parseInt(in.readLine());
		Map<Integer,String> cmd = new HashMap<Integer, String>();
		for(int i=0;i<l;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cmd.put(Integer.parseInt(st.nextToken()),st.nextToken());
			
		}

		Deque<int[]> snake = new ArrayDeque<>();
		map[0][0]=1;
		snake.offerLast(new int[] {0,0});
		int d=1; // 우 1
		int time=1;
		while(true) {
			int[] head= snake.peekLast();
			int hx=head[0]+dx[d];
			int hy=head[1]+dy[d];
			if(!(hx>=0&&hx<n&&hy>=0&&hy<n)) break;
			if(map[hx][hy]==1)break;
			if(map[hx][hy]!=2) {
				int[] tail = snake.pollFirst();
				map[tail[0]][tail[1]]=0;
			}
			
			map[hx][hy]=1;
			snake.offerLast(new int[] {hx,hy});
			String dir=cmd.get(time);
			if(dir!=null)d=dir.equals("D")?(d+1)%4:(d+3)%4;
			time++;
			
		}
		
		System.out.println(time);
		in.close();
	}
}