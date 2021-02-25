package study_9월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1342_행운의문자열 {
	static String msg;
	static int alpha[], ans;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		msg = in.readLine();
		alpha = new int[26];

		for (int i = 0; i < msg.length(); i++) {
			// 각 알파벳 개수 카운트
			alpha[msg.charAt(i) - 'a']++;
			
		}
		dfs(0,"");
		System.out.println(ans);

	}

	static void dfs(int idx, String cur) {
		if (idx == msg.length()) {
			// 문자열 완성하면 카운트 
			ans++;
			return;
		}

		for (int i = 0; i < 26; i++) { // 알파벳 배열 싹 돌림
			if (alpha[i] == 0)// 알파벳 0개인건 패스
				continue;
			if (cur != "" && cur.charAt(cur.length()-1) == (char)('a' + i))
				//현재까지 문자열 비어있지 않고, 현재 문자열의 마지막 알파벳이랑 같은 알파벳이면 패스
				continue;
			alpha[i]--; // 알파벳 개수 감소
			dfs(idx + 1, cur + (char)('a' + i)); // 다음 인덱스 + 현재 문자열에 알파벳 더해줌
			alpha[i]++; // 알파벳 개수 다시 증가

		}

	}
}
