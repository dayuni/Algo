import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(in.readLine());
            pq.offer(num);
        }
        int sum = 0;
        while(pq.size()>1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum+=num1+num2;
            pq.offer(num1+num2);
        }
        System.out.println(sum);
    }
}
