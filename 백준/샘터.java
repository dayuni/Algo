import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K,dist =1;
    static long ans = 0;
    static Queue<Integer> q = new LinkedList<>();
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            q.offer(a);
            set.add(a);
        }
        bfs();
        System.out.println(ans);
    }
    static void bfs(){
        loop:
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
              int x = q.poll();
              int rx = x + 1;
              int lx = x-1;
              if(!set.contains(rx)){
                  q.offer(rx);
                  ans += dist;
                  set.add(rx);
                  K--;
                  if(K==0) break loop;
              }
              if(!set.contains(lx)){
                  q.offer(lx);
                  ans += dist;
                  set.add(lx);
                  K--;
                  if(K==0) break loop;
              }
            }
            dist++;
        }
    }


}
