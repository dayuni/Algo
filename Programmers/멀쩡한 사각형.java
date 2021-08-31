class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        int gcd = GCD(w,h);
        answer = ((long)w*(long)h) - ((((long)w/gcd)+((long)h/gcd)-1)*gcd);
        return answer;
    }
     public int GCD(int a, int b)
	 {
	     if(b==0)return a;
	     else return GCD(b,a%b);
	 }
}
