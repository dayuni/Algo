import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int pro =0;
            if((100-progresses[i])%speeds[i]==0)
                pro = (100-progresses[i])/speeds[i];
            else pro = (100-progresses[i])/speeds[i] +1;
            q.offer(pro);            
        }
        int cnt =1;
        int pre = q.poll();
        while(!q.isEmpty()){
            int now = q.poll();
            if(pre>=now){
                cnt++;
            }else{
                list.add(cnt);
                cnt=1;
                pre=now;
            }            
        }
        list.add(cnt);
        int answer[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
