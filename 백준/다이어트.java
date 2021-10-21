import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int arr[][], out[],mins[];
    static int ans = Integer.MAX_VALUE;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][5];
        mins = new int[4];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0;i<4;i++){
            mins[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            out = new int[N];
            dfs(0, 0, i);
        }
        if (list.size() > 0) {
            System.out.println(ans);
            Collections.sort(list);
            System.out.println(list.get(0));
        } else System.out.println(-1);
    }

    static void dfs(int start, int depth, int cnt) {
        if (depth == cnt) {
            isValid(cnt);
            return;
        }
        for (int i = start; i < N; i++) {
            out[depth] = i;
            dfs(i + 1, depth + 1, cnt);
        }
    }

    static boolean isValid(int cnt) {
        int sum[] = new int[4];
        int min = 0;
        for (int i = 0; i < cnt; i++) {
            int a = out[i];
            sum[0] += arr[a][0];
            sum[1] += arr[a][1];
            sum[2] += arr[a][2];
            sum[3] += arr[a][3];
            min += arr[a][4];
        }
       for(int i=0;i<4;i++){
           if(mins[i]>sum[i])
           return false;
       }

        if (ans >= min) {
            if (ans > min) list.clear();
            String str = "";
            for (int i = 0; i < cnt; i++) {
                str += (out[i] + 1 + " ");
            }
            list.add(str);
            ans = min;
        }
        return true;
    }
}
