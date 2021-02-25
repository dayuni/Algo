package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1759 {
	static int L, C;
	static char ch[], pswd[];
	static char vow[] = { 'a', 'e', 'i', 'o', 'u' };

	 static List<Character> ps = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ch = new char[C];
		pswd = new char[L];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ch);
		perm(0, 0);

	}

	static void perm(int cnt, int start) {
		int v = 0,c=0;
		if (cnt == L) {
			v=0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < 5; j++) {
					if (pswd[i] == vow[j]) {
						v++;
						break;
					}
				}
				c=pswd.length-v;
			}
			//System.out.println("모음 : "+v+" 자음 : "+c);
			if (v >= 1 && c >= 2) {
				for(int i=0;i<L;i++)
				System.out.print(pswd[i]);
				System.out.println();
			}
			return;
		}
		for (int i = start; i < C; i++) {
			pswd[cnt] = ch[i];
			perm(cnt + 1, i + 1);
		}
	}
}
