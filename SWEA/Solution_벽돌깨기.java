package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_벽돌깨기 {
    static class Point{
        int r, c, count;
         
        public Point(int r, int c, int count) {
            super();
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
     
    private static int N, W, H, min;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
             
            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            min = Integer.MAX_VALUE;
            go(0, map);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
             
        }
         
        System.out.print(sb.toString());
         
    }
     
    private static boolean go(int count, int[][] map) {
        int result = getRemain(map);
        if (result == 0) {
            min = 0;
            return true;
        }
 
        if (count == N) {
            if (min > result) min = result;
            return false;
        }
         
        int[][] nMap = new int[H][W];
        for (int j = 0; j < W; j++) {
            int i = 0;
            while (i < H && map[i][j] == 0) ++i;
            if (i == H) continue;
            copy(map, nMap);
            boom(nMap, i, j);
            down(nMap);
            if (go(count+1, nMap)) return true;
        }
         
        return false;
    }
     
    private static void boom(int[][] map, int i, int j) {
        Queue<Point> queue = new LinkedList<Point>();
        if (map[i][j] > 1) queue.offer(new Point(i, j, map[i][j]));
        map[i][j] = 0;
         
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.count == 1) continue;
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.r, ny = p.c;
                for (int k = 1; k < p.count; k++) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if (nx<0 || nx>=H || ny<0 || ny>=W) continue;
                    if (map[nx][ny] == 0) continue;
                     
                    if (map[nx][ny] > 1) queue.offer(new Point(nx, ny, map[nx][ny]));
                    map[nx][ny] = 0;
                }
            }
        }
    }
 
    private static void down(int[][] map) {
        for (int j = 0; j < W; j++) {
            int i = H-1;
            while (i > 0) {
                if (map[i][j] == 0) {
                    int ni = i-1;
                    while (ni > 0 && map[ni][j] == 0) --ni;
                    map[i][j] = map[ni][j];
                    map[ni][j] = 0;
                }
                --i;
            }
        }
    }
 
    private static void copy(int[][] map, int[][] nMap) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                nMap[i][j] = map[i][j];
            }
        }
    }
     
    private static int getRemain(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] > 0) ++count;
            }
        }
        return count;
    }
}