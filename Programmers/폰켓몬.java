import java.util.HashSet;
class Solution {
  public int solution(int[] nums) {
	        int answer = 0;
	        int max = nums.length/2;
	        // hash를 이용해 중복 제거
	        HashSet<Integer> num = new HashSet<>();
	        for(int n : nums) {
	        	num.add(n);
	        }
	        // 중복 제거한  종류가 N/2 보다 크면 답은 N/2
	        if(num.size()>max) {
	        	answer = max;
	        }else {
	        	// 아닌 경우 답은 hash의 크기
	        	answer = num.size();
	        }
	        return answer;
	    }
}
