class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntP = 0, cntY = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'||s.charAt(i)=='P'){
                cntP++;
            }else if(s.charAt(i)=='y'||s.charAt(i)=='Y'){
                cntY++;
            }
        }
        if(cntP==cntY) answer = true;
        else answer = false;
        return answer;
    }
}
