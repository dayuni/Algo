class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(s.length()%2==0){
            sb.append(s.charAt((s.length()/2)-1));
            sb.append(s.charAt(s.length()/2));
        }else{
            sb.append(s.charAt(s.length()/2));
        }
        answer = sb.toString();
        return answer;
    }
}
