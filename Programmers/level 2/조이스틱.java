class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len-1;
        for(int i=0;i<len;i++){
            if(name.charAt(i)<='M'){
                answer += name.charAt(i)-'A';
            }else{
                answer += 'Z'-name.charAt(i)+1;
            }
            int next = i+1;
            while(next<len && name.charAt(next)=='A'){
                ++next;
            }
            min = Math.min(min,i+len-next+Math.min(i,len-next));
        }
        answer += min;
        return answer;
    }
}
