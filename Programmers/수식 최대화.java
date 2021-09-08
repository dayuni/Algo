import java.util.ArrayList;

public class Solution {
	static long answer = 0;
	static ArrayList<Long> nums = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
	static char[] prior = {'+','-','*'};
	static boolean[] visited = new boolean[3];
	public long solution(String expression) {

		String num = "";
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				num += expression.charAt(i);
			} else {
				nums.add(Long.parseLong(num));
				num = "";
				ops.add(expression.charAt(i));
			}
		}
		nums.add(Long.parseLong(num));
        
        
		dfs(0,new char[3]);
		return answer;
	}
	public static void dfs(int count, char[] c) {
		if(count==3) {
			ArrayList<Long> nums2 = new ArrayList<>(nums);      // ArrayList 복사
			ArrayList<Character> ops2 = new ArrayList<>(ops);
			
			for(int i=0;i<c.length;i++) {
				for(int j=0;j<ops2.size();j++) {                  // 현재 연산자 계산할 차례면
					if(c[i]==ops2.get(j)) {   
						Long res = calc(nums2.remove(j),nums2.remove(j),c[i]);  // 숫자 2개 빼서 계산
						nums2.add(j,res);                                       // 계산 한 결과를 다시 넣어줌
						ops2.remove(j);                                         // 계산 완료된 연산자 제거
						j--;                                                    // j 감소
					}
				}
			}
			answer = Math.max(answer, Math.abs(nums2.get(0)));            // 절대값으로 MAX 값 구함
			return;
		}
		
		for(int i=0;i<3;i++) {
			if(!visited[i]) {
				visited[i]= true;
				c[count] = prior[i];
				dfs(count+1,c);
				visited[i] = false;
			}
		}
	}
	public static Long calc(Long num1, Long num2, char op) {
		long num = 0;
		switch (op) {
			case '+': {
				return num1 + num2;
			}
			case '-': {
				return num1 - num2;
			}
			case '*': {
				return num1 * num2;
			}
		}
		return num;
	}
}
