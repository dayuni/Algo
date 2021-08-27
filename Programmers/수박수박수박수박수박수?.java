class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(n%2==0){
            for(int i=0;i<n/2;i++){
                sb.append("수박");
            }
        }else{
            for(int i=0;i<n/2;i++){
                sb.append("수박");
            }
            sb.append("수");
        }
        answer = sb.toString();
        return answer;
    }
}
