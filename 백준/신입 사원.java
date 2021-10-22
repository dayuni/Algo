import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,T,arr[][];
    static boolean[][] check;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(in.readLine());
            arr = new int[N][2];
            check = new boolean[N][2];
            for(int i=0;i<N;i++){
               StringTokenizer st = new StringTokenizer(in.readLine());
               arr[i][0] =  Integer.parseInt(st.nextToken());
               arr[i][1] =  Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr,(o1,o2)->{
               if(o1[0]>o2[0])return 1;
               else return -1;
            });
            int ans = N;
            int max = arr[0][1];
            for(int i=1;i<N;i++){
                int now = arr[i][1];
                if(max<now){
                    ans--;
                }
                if(max>now){
                    max = now;
                }
            }
            System.out.println(ans);
        }
    }


}
