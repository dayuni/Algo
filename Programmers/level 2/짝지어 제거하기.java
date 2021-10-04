import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                 String pre = stack.peek();
                 String cur = String.valueOf(s.charAt(i));
                 if(pre.equals(cur))
                 {
                   stack.pop();
                 }else {
                   stack.push(cur);
                 }   
           }
        }
        return stack.size()==0?1:0;
    }
}
