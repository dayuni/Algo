class Solution {
  public static String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append(' ');
            }else {
                if(s.charAt(i)>='a'&&s.charAt(i)<='z'&&s.charAt(i)+n>'z')
                {
                	sb.append((char)(s.charAt(i)-26+n));
                }else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'&&s.charAt(i)+n>'Z') {
                	sb.append((char)(s.charAt(i)-26+n));                	
                }
                else sb.append((char)(s.charAt(i)+n));
            }
        }
        answer = sb.toString();
        return answer;
    }
}
