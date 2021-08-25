import java.util.*;
class Solution {
    // 중복제거를 위해 set사용
    static Set<Integer> set = new HashSet<>();    
	 public static int[] solution(int[] numbers) {
	        int[] answer = {};
	        boolean[] visited= new boolean[numbers.length];
	        combination(numbers,visited,0,numbers.length,2);
	        ArrayList<Integer> list = new ArrayList<>(set); // set을 ArrayList로 변환
	        answer = new int[list.size()];
	        for(int i=0;i<list.size();i++) {
	        	answer[i]=list.get(i);
	        }
           Arrays.sort(answer); // 정렬
	        return answer;
	    }
	    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
	        if(r==0){
	        	int sum=0;
	        	for(int i=0;i<n;i++) {
                    // 뽑은 두개의 값을 더해줌 
	        		if(visited[i]) {	        			
	        			sum+=arr[i];
	        		}	        		
	        	}
	        	set.add(sum);   // 헙을 set에 넣어줌
	            return;
	        }
	        for(int i=start;i<n;i++){
	            visited[i]=true;
	            combination(arr,visited,i+1,n,r-1);	            
	            visited[i]=false;
	        }
	    }
}
