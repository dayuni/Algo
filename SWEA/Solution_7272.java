package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 
어느 날 경근이는 알파벳 대문자로 이루어진 두 문자열을 비교해야 했는데, 이 날은 공교롭게도 안경이 없었다.
경근이는 매우 눈이 나빠서 안경을 벗으면 문자열을 문자 단위로 구별할 수는 있지만, 두 문자가 정확히 같은 지는 알지 못한다.
특히 알파벳 대문자 같은 경우 문자에 나 있는 구멍의 개수가 같으면 같은 문자이고, 다르면 다른 문자라고 생각한다.
예를 들어 구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ들을 같은 문자로 생각하고,
구멍이 한 개 나 있는 ADOPQR들을 같은 문자로 생각하며,
구멍이 두 개 나 있는 유일한 문자 B는 유일하게 정확히 알 수 있다.
알파벳 대문자로 이루어진 두 문자열이 주어졌을 때, 경근이는 두 문자열이 같다고 판별하는지 다르다고 판별할 것인가?
경근이가 주어진 두 문자열을 같은 것으로 생각하면 “SAME”을, 다른 것으로 생각하면 “DIFF”를 출력한다.

 */

public class Solution_7272 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int alpa[]={1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		// 알파벳의 구멍의 개수를 배열에 입력
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1;test_case<=T;test_case++) {
			st=new StringTokenizer(in.readLine());
			String s1 = st.nextToken(); // 비교할 문자 1
			String s2 = st.nextToken(); // 비교할 문자 2
			int flag =0;
			for(int i=0;i<s1.length();i++)
			{
				if(s1.length()!=s2.length()) { //길이가 다르면 다른 문자이기 때문에 break;
					break;
				}
				if(alpa[s1.charAt(i)-'A']==alpa[s2.charAt(i)-'A'])
				{
					flag++; // 문자1의 구명 개수와 문자 2의 구멍 개수가 같으면 flag를 증가
				}
			}
			if(flag==s1.length()) // flag가 문자열의 길이와 같으면 ( 모두 같을 때 ) SAME 출력
				System.out.println("#"+test_case+" SAME");
			else
				System.out.println("#"+test_case+" DIFF");
		}
		
	}
}
