import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();
    static int num[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        check(0, 0);
        Collections.sort(list);
        if (N > 1023) System.out.println(-1);
        else System.out.println(list.get(N - 1));
    }

    static void check(long sum, int i) {
        if (!list.contains(sum)) list.add(sum);
        if (i >= 10) return;
        check((sum * 10) + num[i], i + 1);
        check(sum, i + 1);
    }

}
