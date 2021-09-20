import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N,M,sum,ans=Integer.MAX_VALUE;
	static int map[][];
	static boolean v[];
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}	
	static List<Point> chicken = new ArrayList<>();
	static List<Point> home = new ArrayList<>();
	static Point[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home.add(new Point(i,j));
				}
				if(map[i][j]==2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		selected = new Point[M];
		comb(0,0);
		System.out.println(ans);
		
	}
	public static void comb(int start,int depth) {
		if(depth==M) {
			int chicken_dist = 0;
			for(int i=0;i<home.size();i++) {
				Point h = home.get(i);
				int min = Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					Point c = selected[j];
					min = Math.min(min, Math.abs(h.x-c.x)+Math.abs(h.y-c.y));
				}
				chicken_dist +=min;				
			}
			ans = Math.min(ans, chicken_dist);
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			selected[depth]=chicken.get(i);
			comb(i+1,depth+1);
		}
	}
	
}
