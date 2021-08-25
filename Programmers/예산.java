import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // 정렬 
        Arrays.sort(d);
        int sum=0;
        for(int i=0;i<d.length;i++){
            // 각 부서의 금액 합계를 구함
            sum+=d[i];
            // 합계가 예산보다 작거나 같은 경우를 확인
            if(sum<=budget){
                answer++; 
            }
        }
        return answer;
    }
}
