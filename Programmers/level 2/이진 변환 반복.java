class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String str = "";
        while(true){            
            str = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    answer[1]++;
                }else{
                    str += "1";
                }
            }
            s = Integer.toBinaryString(str.length());
            answer[0]++;            
            if(s.equals("1")) break;
        }
        return answer;
    }
}
