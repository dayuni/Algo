class Solution {
  	 public static String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = {};
	        answer = new String[n];
	        int sum[][] = new int[n][n];
         
	        for(int i=0;i<n;i++) {
                // 10진수를 2진수로 바꿔준 뒤 n*n 배열에 담아준다
	        	String binary = String.format("%"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));  
	        	for(int j=0;j<n;j++){                    
	        		sum[i][j]=binary.charAt(j);
	        	}
	        }
         
	        for(int i=0;i<n;i++) {
	        	String binary = String.format("%"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));  
	        	for(int j=0;j<n;j++) {
                    // 배열의 값이 모두 0인경우 0
	        		if((sum[i][j]=='0')&&(binary.charAt(j)=='0')) {
	        			sum[i][j]=0;
	        		}else if((sum[i][j]=='1')||(binary.charAt(j)=='1')) {
	        			// 하나라도 1이 존재하면 1
                        sum[i][j]=1;
	        		}
	        	}
	        }       
         // 1인경우 # , 0인경우 공백을 출력
         for(int i=0;i<n;i++) {
	        	StringBuilder sb = new StringBuilder();
	        	for(int j=0;j<n;j++) {
	        		if(sum[i][j]==1) { 
	        			sb.append("#");
	        		}else sb.append(" ");
	        	}
	        	answer[i] = sb.toString();
	        }
	        
	        return answer;
	    }
}
