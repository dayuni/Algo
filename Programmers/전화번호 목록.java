import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i],i);         // Map에 모든 번호를 담음
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){            
                if(map.containsKey(phone_book[i].substring(0,j))){  // 현재 번호를 0~번호의 길이까지 잘라보면서 map에 들어있는지 
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
