import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);        
        for(int i=0;i<operations.length;i++){
            String str[] = operations[i].split(" ");
            if(str[0].equals("I")){
                pq.offer(Integer.parseInt(str[1]));
                
            } else if(str[0].equals("D")) {
                if(str[1].equals("1")){
                    pq.poll();
                }
                else if(str[1].equals("-1")){
                    PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1,o2)->o1-o2);
                    pq2.addAll(pq);                    
                    pq2.poll();
                    pq.clear();
                    pq.addAll(pq2);
                }
            }            
        }
        if(pq.isEmpty()){
                answer[0]=0;
                answer[1]=0;
            }
        else {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                while(!pq.isEmpty()){
                    int num = pq.poll();
                    max = Math.max(num,max);
                    min = Math.min(num,min);
                }
                System.out.println(max+" "+min);
                answer[0] = max; answer[1]=min;    
            }
        return answer;
    }
}
