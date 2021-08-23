class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
			 String answer = "";
			int arr[][] = new int[languages.length + 1][5];	// 선호점수를 계산할 배열
			String job[] = { "SI", "CONTENTS", "HARDWARE", "PORTAL", "GAME" };

			for (int k = 0; k < languages.length; k++) {
				for (int i = 0; i < 5; i++) {
					String str = table[i];
					String[] s = str.split(" ");		// table을 나눠서 언어 확인
					int num = 6;            
	                int cnt =0;
					for (int j = 1; j < 6; j++) {	  
	                    cnt =0;
	                    num--; 
						if (languages[k].equals(s[j])) {	// 언어가 해당되는 직업군 확인
	                        cnt++;
							break;
						}
					}
	                if(cnt==0) arr[k][i] = 0;				// 직업군 선호 언어가 아닐 때 0  
	                else arr[k][i] = num;
				}
			}
			int max =0;
			for (int i = 0; i < 5; i++) {
				int sum = 0;
				for (int j = 0; j < languages.length; j++) {
					sum += arr[j][i] * preference[j];		// 선호도 * 직업군 언어 = 점수 총합	         
	                arr[languages.length][i] = sum;	 
				}
				if(arr[languages.length][i]>max) {			// 총합이 최대일 때
					max = Math.max(arr[languages.length][i],max);	
					answer = job[i];											
				}
				if(arr[languages.length][i]==max) {			// 총합이 같은 직업군이 여러개 일 때
					if(job[i].charAt(0)<answer.charAt(0)) { // 직업군의 맨 앞글자를 비교해서 빠른것이 정답
						answer = job[i];
					}
				}
			}			
	       
			return answer;
    }
}
