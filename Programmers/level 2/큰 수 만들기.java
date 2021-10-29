class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int tmp = 0;
        for(int i=0;i<number.length()-k;i++){
            tmp = 0;
            for(int j=idx;j<=i+k;j++){
                if(tmp < number.charAt(j)-'0'){
                    tmp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(tmp);
        }
        answer = sb.toString();
        return answer;
    }
}
