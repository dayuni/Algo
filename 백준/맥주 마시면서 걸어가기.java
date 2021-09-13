import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 10000001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			
			int n = Integer.parseInt(in.readLine());
			int arr[][] = new int[n+2][n+2];
			List<int[]> point = new ArrayList<>();
			
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					arr[i][j]=INF;
					if(i==j) arr[i][j]=0;
				}
			}
			
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				point.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i==j)continue;
					int p1[] = point.get(i);
					int p2[] = point.get(j);
					int dist = Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
					if(dist<=1000)
						arr[i][j]=1;
				}
			}
			for(int k=0;k<n+2;k++) {
				for(int i=0;i<n+2;i++) {
					for(int j=0;j<n+2;j++) {
						arr[i][j] = Math.min(arr[i][k] + arr[k][j],arr[i][j]);
					}
				}
			}
			
			if(arr[0][n+1]>0 && arr[0][n+1]<INF) {
				System.out.println("happy");
			}else
				System.out.println("sad");
		}
		
		
	}
}
