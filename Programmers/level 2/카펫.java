import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=sum;i++){
            int row = i;
            int col = sum/row;
            
            if(row>col)continue;
            
            if((row-2)*(col-2)==yellow){
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
      
        return answer;
    }
}
