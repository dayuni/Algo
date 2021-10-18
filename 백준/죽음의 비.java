import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, H, D, ans = Integer.MAX_VALUE;
    static int sx, sy, ex, ey;
    static boolean visited[];
    static List<int[]> umbrella = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[11];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'U') {
                    umbrella.add(new int[]{i, j});
                } else if (c == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(sx, sy, H, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int x, int y, int h, int d, int cnt) {
        if (Math.abs(ex - x) + Math.abs(ey - y) <= h + d) {
            ans = Math.min(ans, cnt + Math.abs(ex - x) + Math.abs(ey - y));
            return;
        }
        for (int i = 0; i < umbrella.size(); i++) {
            int dis = Math.abs(umbrella.get(i)[0] - x) + Math.abs(umbrella.get(i)[1] - y);
            if (h + d < dis || visited[i]) continue;
            visited[i] = true;
            if (d < dis) {  // 우산으로 비 막을 수 없을 때
                dfs(umbrella.get(i)[0], umbrella.get(i)[1], h + d-dis, D, cnt + dis);
            } else { // 우산으로 비 막을 수 있을 때
                dfs(umbrella.get(i)[0], umbrella.get(i)[1], h, D, cnt + dis);
            }
            visited[i] = false;
        }
    }

}
