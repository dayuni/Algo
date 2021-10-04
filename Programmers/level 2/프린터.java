import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int prior : priorities){
            pq.offer(prior);
        }
        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==pq.peek()){
                    if(location==i){
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}
