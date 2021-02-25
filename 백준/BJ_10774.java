package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10774 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int J = Integer.parseInt(in.readLine()); // 저지의 수
		int A = Integer.parseInt(in.readLine()); // 선수의 수
		int size[] = new int[J+1];
		int p_size[] = new int[A]; // 선수 요구 사이즈
		int num; // 선수 요구 번호 
		boolean selected[] = new boolean[J];
		for (int i = 0; i < J; i++) {
			switch (in.readLine().charAt(0)) {
			case 'S':
				size[i] = 0;
				break;
			case 'M':
				size[i] = 1;
				break;
			case 'L':
				size[i] = 2;
				break;
			}
		}
		int count =0;
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(in.readLine());
			switch (st.nextToken().charAt(0)) {
			case 'S':
				p_size[i] = 0;
				break;
			case 'M':
				p_size[i] = 1;
				break;
			case 'L':
				p_size[i] = 2;
				break;
			}
			num = Integer.parseInt(st.nextToken());
			
			if(!selected[num]) {
				if(size[num]>=p_size[i]) {
					selected[num]=true;
					count++;
				}
			}
		}


		System.out.println(count);
	}
}
