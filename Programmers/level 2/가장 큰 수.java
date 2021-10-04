import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);      
        }
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){   // 문자열 더한 값을 비교
                return(b+a).compareTo(a+b);           // 내림차순

            }
        });
        
        if(str[0].equals("0")) return "0";            // 0으로 시작하면 0
        for(String s: str) answer+=s;                 // 
        return answer;
    }
}
