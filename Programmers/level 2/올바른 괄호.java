import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(arr[i]);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        
        return answer;
    }
}
