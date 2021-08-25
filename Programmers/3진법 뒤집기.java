class Solution {
    public int solution(int n) {
        int answer = 0;
        String three = "";
        
        while(n>0){
            // 3진법을 구하려면 뒤에서부터 더해줘야하지만, 
            // 앞뒤 반전을 한번에 구하기 때문에 앞에서부터 더해줌
            three += (n%3);
            n/=3;
        }
        // 10진법으로 변환
        answer = Integer.parseInt(three,3);
        return answer;
    }
}
