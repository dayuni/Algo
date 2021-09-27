import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w,h,arr[][],cnt;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			arr = new int[h][w];
			visited= new boolean[h][w];
			cnt=0;
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j]&&arr[i][j]==1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
					
		System.out.println(cnt);	
		}
		
	}
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=h||ny>=w) continue;
			if(arr[nx][ny]==0)continue;
			if(visited[nx][ny])continue;
			dfs(nx,ny);
		}
	}
}
