import java.util.PriorityQueue;

public class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<scoville.length;i++) {
			pq.offer(scoville[i]);
		}
		while(true) {
			if(pq.peek()>=K) {
				break;
			}else if(pq.size()==1){
                answer=-1;
                break;
            }
            int pre = pq.poll();
            int num = pre + pq.poll()*2;
			pq.offer(num);
			answer++;
		}
		
		return answer;

	}
}
