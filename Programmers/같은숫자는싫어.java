import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
          int[] answer = {};
	        List<Integer> list = new ArrayList<>();
	        int pre = -1;
	        for(int i=0;i<arr.length;i++){
            // 이전의 숫자와 비교해서 다르면 리스트에 추가해줌
	           if(pre!=arr[i]) {
	        	   list.add(arr[i]);
	           }
	           pre=arr[i];
	        }
	        answer = new int[list.size()];
	        for(int i=0;i<list.size();i++) {
	        	answer[i] = list.get(i);
	        }
	        return answer;
    }
}
