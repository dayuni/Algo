package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2607 {
	static int N,cnt=0;
	static char[] origin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		String origin = in.readLine();
		int size = origin.length();
		int alpha[] = new int[26];
		for(int i=0;i<size;i++) {
			alpha[origin.charAt(i)-'A']++;		// 알파벳 개수 증가 
		}
		
		int ans =0;
		for(int i=0;i<N-1;i++) {
			int tmp[] = alpha.clone();
			String str = in.readLine();
			int cnt=0;
			for(int j=0;j<str.length();j++) {
				if(tmp[str.charAt(j)-'A']>0) {		// 원래 단어에 들어있는 알파벳이 존재하면
					cnt++; 							// 카운트를 증가해주고 
					tmp[str.charAt(j)-'A']--;		// 알파벳 개수를 줄여줌 
				}
			}
			if(size-1==str.length() && cnt == str.length()) {	// 원래 단어보다 한글자 작은 경우 
				ans++;								
			}else if(size==str.length()) {				// 원래 단어와 같은 경우
				if(cnt==size||cnt==size-1)ans++;
			}else if(size+1==str.length()) {			// 원래 단어 보다 한글자 많은 경우
				if(cnt==size)ans++;
			}
		}
		System.out.println(ans);
	}
}
