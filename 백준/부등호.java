import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int k;
    static int[] output;
    static char[] c = new char[10];
    static boolean[] visited = new boolean[10];
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0;i<k;i++){
            c[i] = st.nextToken().charAt(0);
        }
        perm(0,"");
        Collections.sort(res);
        System.out.println(res.get(res.size()-1));
        System.out.println(res.get(0));
    }
    public static void perm(int depth,String s){
        if(depth==k+1){
            res.add(s);
            return;
        }
        for(int i=0;i<10;i++){
            if(visited[i])continue;
            if(depth==0||check(Character.getNumericValue(s.charAt(depth-1)),i,c[depth-1])){
                visited[i]=true;
                perm(depth+1,s+i);
                visited[i]=false;
            }
        }
    }
    private static boolean check(int a, int b, char c) {
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }

}
