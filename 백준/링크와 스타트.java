import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,arr[][],min = Integer.MAX_VALUE;
    static boolean selected[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<n;i++){
            selected = new boolean[n];
            comb(0,0,i);
        }
        System.out.println(min);

    }
    static void comb(int start, int depth, int r){
        if(depth==r){
            List<Integer> starts = new ArrayList<>();
            List<Integer> links = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(selected[i]) starts.add(i);
                else links.add(i);
            }
            int s = 0;
            int l = 0;
           for(int i=0;i<starts.size();i++){
               for(int j=i+1;j<starts.size();j++){
                   s+=arr[starts.get(i)][starts.get(j)];
                   s+=arr[starts.get(j)][starts.get(i)];
               }
           }
            for(int i=0;i<links.size();i++){
                for(int j=i+1;j<links.size();j++){
                    l+=arr[links.get(i)][links.get(j)];
                    l+=arr[links.get(j)][links.get(i)];
                }
            }
            min = Math.min(min,Math.abs(l-s));
            return;
        }
        for(int i = start;i<n;i++){
            selected[i] = true;
            comb(i+1,depth+1,r);
            selected[i] = false;
        }


    }
}
