class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            int sum = 0;
            int j=i;
            while(true){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }else if(sum>n)break;
                j++;
            }
        }        
        return answer;
    }
}
