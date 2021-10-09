import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(in.readLine());
        }
        HashSet<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if(s1.length()>s2.length()){
                    return 1;
                }else if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }else return -1;
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
