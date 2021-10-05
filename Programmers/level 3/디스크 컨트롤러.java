import java.util.*;
class Solution {
    public static class Job implements Comparable<Job>{
        int start;
        int take;
        public Job(int start, int take){
            this.start = start;
            this.take = take;
        }
        @Override
        public int compareTo(Job job){
            return this.take-job.take;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 1;
        int i;
        int cur  =0;
       Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Job> pq = new PriorityQueue<>();
        pq.offer(new Job(jobs[0][0], jobs[0][1]));
        while(!pq.isEmpty()){
            if(cur<pq.peek().start) cur = pq.peek().start;
            cur += pq.peek().take;
            answer += cur - pq.poll().start;
 
            for(i=idx;i<jobs.length;i++){
                if(jobs[i][0]<=cur){
                    pq.add(new Job(jobs[i][0],jobs[i][1]));
                }else{
                    if(pq.isEmpty()){
                        pq.add(new Job(jobs[i][0],jobs[i][1]));
                        i++;
                    }
                    break;
                }
            }
            idx = i;
        }
        return answer/jobs.length;
    }
}
