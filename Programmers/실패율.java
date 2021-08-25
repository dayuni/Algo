import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> fails = new HashMap<>();
                        
        for(int i=0;i<N;i++){
            int total = 0;
            int fail = 0;
           
            for(int j=0;j<stages.length;j++){
                // 스테이지에 도달한 사람의 수
                if(stages[j]>=(i+1)){
                    total ++;
                }
                // 스테이지를 클리어하지 못한 사람의 수
                if(stages[j]==(i+1)){                    
                    fail++;
                }                
            }          
            // 클리어하지 못한 사람이 없는 경우는 0, 아닌 경우 실패율 계산
            if(fail==0) fails.put(i,0d);
            else fails.put(i,(double)fail/(double)total);
            
        }
        
        // value 값을 비교해서 가장 큰 값일 때의 key부터 순서대로 answer에 담아줌 
        for(int i=0;i<N;i++){
            double max = -1;
            int maxKey = 0;
            for(int key:fails.keySet()){
                if(max<fails.get(key)){
                    max = fails.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey+1;
            fails.remove(maxKey);
        }       
        
        return answer;
    }
}
