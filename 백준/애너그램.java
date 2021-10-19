import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,len;
    static char[] arr,perm;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        for(int i=0;i<N;i++){
            String str = in.readLine();
            arr = str.toCharArray();
            len = arr.length;
            perm = new char[len];
            Arrays.sort(arr);
            visited= new boolean[len];
            dfs(0);
        }
        System.out.println(sb);
    }
    public static void dfs(int depth){
        if(depth==len){
            sb.append(perm).append("\n");
            return;
        }
        perm[depth] =0;
        for(int i=0;i<len;i++){
            if(visited[i])continue;
            System.out.println(depth + " " + perm[depth] + " "+ arr[i]);
            if(perm[depth]>=arr[i])continue;

            visited[i]=true;
            perm[depth]=arr[i];
            dfs(depth+1);
            visited[i]=false;
        }
    }
}
