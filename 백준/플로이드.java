import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int INF = 10000001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int arr[][] = new int[n+1][n+1];
		// 배열을 INF로 초기화하고 자기자신으로 가는 경로는 0으로 처리
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]=INF;
				if(i==j) arr[i][j]=0;
			}
		}
		// 입력
		for(int i=0;i<m;i++) {
			String str = in.readLine();
			String s[] = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		// i->k->j 와 i->j를 비교해서 작은 값 저장, 
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j],arr[i][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==INF) sb.append("0 ");
				else sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
