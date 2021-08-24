class Solution {
public String solution(int[] numbers, String hand) {
	        String answer = "";

	        StringBuilder sb = new StringBuilder();
	        int curL = 10; // *을 의미
	        int curR = 12; // #을 의미
	        
	        for(int i=0;i<numbers.length;i++)
	        {	        	
	        	
	        	if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
	        		// 왼손인 경우 L을 추가하고 현재 왼손 위치 저장
	        		sb.append("L");
	        		curL = numbers[i];	        		
	        	}else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
	        		// 오른손인 경우 R 추가하고 현재 오른손 위치 저장
	        		sb.append("R");
	        		curR = numbers[i];
	        	}else{
	        		// 왼손, 오른손과의 거리를 각각 계산 
	        		int leftDis = getDistance(curL, numbers[i]);
	        		int rightDis = getDistance(curR, numbers[i]);
	        		
	        		
	        		if(leftDis>rightDis) {
	        			sb.append("R");
	        			curR = numbers[i];
	        		}else if(rightDis>leftDis) {
	        			sb.append("L");
	        			curL=numbers[i];
	        		}else {
	        			// 거리가 같은 경우 hand를 비교
	        			if(hand.equals("left")) {
	        				sb.append("L");
	        				curL=numbers[i];
	        			}else {
	        				sb.append("R");
	        				curR=numbers[i];
	        			}
	        		}
	        	}
	        }
	        answer = sb.toString();
	        return answer;
	    }
	public static int getDistance(int idx,int num) {
		idx = (idx==0)?11:idx;
		num = (num==0)?11:num;
		
		int x = (idx-1)/3;
		int y = (idx-1)%3;
		int numX = num/3;
		int numY = 1;
		
		return Math.abs(x-numX)+Math.abs(y-numY);
	}
}
