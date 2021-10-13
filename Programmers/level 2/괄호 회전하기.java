import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
           if(check(s))answer++;
           s = s.substring(1, s.length()) + s.substring(0,1);
        }
        return answer;
    }
    public static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                stack.push(str.charAt(i));      
            }else{
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    char s = str.charAt(i);
                    if(s==')'&&c=='('){
                        continue;
                    }else if(s==']'&&c=='['){
                        continue;
                    }else if(s=='}'&&c=='{'){
                        continue;
                    }else return false;
                }else return false;              
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
}
