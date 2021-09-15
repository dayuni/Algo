import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Integer arr[] = new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr,Collections.reverseOrder());
		int count =0;
		for(int i=0;i<n;i++) {
			if(arr[i]<=k) {
				count +=(k/arr[i]);
				k = k%arr[i];
			}
			
		}
		System.out.println(count);
	}

}
