import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 10000001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n+1][n+1];
		int res[] = new int[n+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]=INF;
				if(i==j) arr[i][j]=0;
			}
		}

		for(int i=0;i<m;i++) {
			String str = in.readLine();
			String s[] = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			arr[a][b] = arr[b][a] = 1;
		}
		
		// i->k->j 와 i->j를 비교해서 작은 값 저장, 
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j],arr[i][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=1;j<=n;j++) {
				sum+=arr[i][j];
			}
			res[i] = sum;
			min = Math.min(min, sum);
		}
		
		for(int i=1;i<=n;i++) {
			if(res[i]==min) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
