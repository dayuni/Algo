import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        while(true){
            StringBuilder sb = new StringBuilder();
            sb.append(N);
            if(sb.toString().equals(sb.reverse().toString()) && isPrime(N)){
                System.out.println(N);
                break;
            }N++;
        }
    }
    public static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }

}
