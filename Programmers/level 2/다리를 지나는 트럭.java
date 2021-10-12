import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q =new LinkedList<>();
        int currentWeight = 0, idx=0;
        while(true){
            if(idx==truck_weights.length) break;
            if(q.size()==bridge_length){
                currentWeight-=q.poll();
            }else if(currentWeight+truck_weights[idx]>weight){
                q.offer(0);
                answer++;
            }else{
                q.offer(truck_weights[idx]);
                currentWeight+=truck_weights[idx];
                answer++;
                idx++;
            }
        }
        return answer + bridge_length;
    }
}
