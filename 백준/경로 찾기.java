import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			for(int j=0;j<N;j++) {
				String[] num = str.split(" ");
				arr[i][j] = Integer.parseInt(num[j]);
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][k]==1 && arr[k][j]==1) {
						arr[i][j]=1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
