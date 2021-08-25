class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                // 약수의 개수를 구함
                if(i%j==0){
                    count++;
                }
            }
            // 개수가 짝수이면 더하고, 홀수이면 빼줌
            if(count%2==0){
                answer+=i;
            }else {
                answer-=i;
            }
        }
        return answer;
    }
}
