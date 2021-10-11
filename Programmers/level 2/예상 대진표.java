class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        for(int i=0;i<n;i++){
            if(a==b) break;
            if(a%2!=0)a+=1;
            if(b%2!=0)b+=1;
            a/=2;
            b/=2;      
            answer++;
        }
        
        return answer;
    }
}
