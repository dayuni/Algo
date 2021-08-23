class Solution {
    public String solution(String new_id) {
      String answer = "";
			String lower = new_id.toLowerCase(); // 1. 대문자 -> 소문자로 변경
			
			int len = lower.length();
			
			String tmp = lower.replaceAll("[^a-z\\d\\-_.]*", ""); // 2. 소문자, 숫자, -, _, .가 아닌 경우 제거
			//  [] 안에 ^로 시작하는 경우 not을 의미 
			// a-z 는 소문자, \\d는 숫자
			
			tmp = tmp.replaceAll("\\.{2,}","."); // 3. 마침표가 2번 이상 연속된 부분을 한개로 변경
			// {} 횟수 또는 범위를 나타냄 , 2회 이상을 의미
			
			tmp = tmp.replaceAll("^[.]|[.]$",""); // 4. 마침표가 처음이나 끝에 위치하면 제거 
			// ^ 는 문자의 시작을 의미
			// []$ 는 문자의 끝을 의미
			
			// 5. 빈 문자열이면 a 대입
			if(tmp.isEmpty()) {
				tmp ="a";
			}
			
			// 6. 16글자 이상이면 15개 문자를 제외하고 제거
			if(tmp.length()>=16) {
				tmp = tmp.substring(0,15);
			}
			tmp = tmp.replaceAll("[.]$", ""); // 제거 후 마침표가 끝에 위치하면 제거
			
			// 7. 2글자 이하면 마지막 글자를 길이가 3이 될때까지 붙임
			if(tmp.length()<=2) {			
				char c = tmp.charAt(tmp.length()-1);
				while(true) {					
					tmp = tmp + c;	
					if(tmp.length()==3)break;
				}
			}
			answer = tmp;
			return answer;
    }
}
