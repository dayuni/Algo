import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int num =1;
        int turn =1;
        int cnt =1;
        boolean flag = false;
        set.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(cnt%n==0) turn++;
            cnt++;
            if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                flag = true;
                num += (i%n); 
                break;
            }
            else if(set.contains(words[i])){
                flag=true;
                num += (i%n);
                break;
            }            
            set.add(words[i]);
        }
        if(!flag){
            answer[0] = answer[1] = 0;
        }else {
            answer[0] = num;
            answer[1] = turn;    
        }
        
        return answer;
    }
}
