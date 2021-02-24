package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Bj_16956 {
	static int R,C;
	static char map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];			
		boolean flag = true;
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}	
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='W')	// 늑대를 찾으면 
				for(int d=0;d<4;d++) {	
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx<0||nx>=R||ny<0||ny>=C)continue; // 범위를 벗어날 때 continue
					if(map[nx][ny]=='.') {	// 빈 공간을 울타리로 막아줌
						map[nx][ny]='D';
					}else if(map[nx][ny]=='S') {	// 양인경우 -> 막을 수 없음 flag를 변경해줌 
						flag = false;
					}
				}
			}
		}
		if(!flag) System.out.println(0);
		else {
			System.out.println(1);
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}	
		}
	}
}
