class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	    	int[] grade = {6,6,5,4,3,2,1};      // 로또의 순위
	    	int[] answer = {};
	    	answer = new int[2];
	        int cnt = 0;
	        int cnt0 =0;
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i=0;i<6;i++) {
                if(lottos[i]==0) {        // 0의 개수를 체크
	        			cnt0++;
	        		}
	        	for(int j=0;j<6;j++) {
	        		if(lottos[i]==win_nums[j])  // 당첨 번호와 몇개가 일치하는지 체크
	        			cnt++;
	        	}
	        }
	        if(cnt0==0) {                   // 숫자가 모두 0인 경우는 최소, 최대 등수가 같음
	        	min = cnt;
	        	max = cnt;
	        }else {                         // 일치하는 숫자의 수 , 일치하는 개수 + 0의 개수가 될 때 최대 등수 
	        	min = cnt;
	        	max = cnt+cnt0;
	        }
	        answer[0]= grade[max];
	        answer[1]= grade[min];
	        
	        
	        return answer;
	    }
	}
