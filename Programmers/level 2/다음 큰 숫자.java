class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = binary(n);    
        int index = 1;
        while(true){
            int next = n + index;
            if(count == binary(next)){
                answer = next;
                break;
            }
            index++;
        }
        return answer;
    }
    public int binary(int n){
        String str = Integer.toBinaryString(n);
        int count = 0;
        char[] strArr = str.toCharArray();
        for(int i=0;i<strArr.length;i++){
            if(strArr[i]=='1') count++;
        }
        return count;
    }
}
