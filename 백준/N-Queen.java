import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] col;
    static int ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        col = new int[N+1];
        Queen(1);
        System.out.println(ans);
    }
    public static  void Queen(int rowNo){
        if(rowNo>N){
            ans++;
            return;
        }
        for(int j=1;j<=N;j++){
            col[rowNo] = j;
            if(check(rowNo))
                Queen(rowNo+1);
        }
    }
    public static boolean check(int rowNo){
        for(int i=1;i<rowNo;i++){
            if((col[rowNo]==col[i])||Math.abs(col[rowNo]-col[i])==rowNo-i)
                return false;
        }
        return true;
    }

}
