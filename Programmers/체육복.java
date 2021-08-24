import java.util.*;
class Solution {
public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int lost1 =0;
		int cnt =0;
  
		Arrays.sort(lost);
	  Arrays.sort(reserve);
  
		// 여벌옷 있는데 도난당한 경우
		for(int i=0;i<lost.length;i++) {
			for(int j=0;j<reserve.length;j++) {
				if(lost[i]==reserve[j]) {
					lost1++;
					lost[i]=-1;
					reserve[j]=-1;
					break;
				}
			}
		}
		
		// 빌려준 경우는 -1로 만들어서 중복으로 빌려주지 않도록 처리 
		for(int i=0;i<lost.length;i++) {
			for(int j=0;j<reserve.length;j++) {
				if(lost[i]==reserve[j]+1||lost[i]==reserve[j]-1) {
					cnt++;
					reserve[j]=-1;
					break;
				}
			}
		}
		// 전체 학생 수 - 도난 당한 학생 수 - 여벌 옷 있는데 도난 당한 학생 수 + 빌려준 경우
		answer=n-lost.length+lost1+cnt;
		return answer;
	}
}
