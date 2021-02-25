package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int student[][] = new int[2][6];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[sex][grade-1]++;
		}
		
		int count =0;
		for(int i=0;i<6;i++) {
			count += (int) Math.ceil((double)student[0][i]/(double)K);
			count += (int) Math.ceil((double)student[1][i]/(double)K);
		}
		System.out.println(count);
	}
}
