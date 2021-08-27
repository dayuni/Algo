class Solution {
   public int[] solution(int n, int m) {
	        int[] answer = new int[2];
	        int gcd = GCD(n,m);
	        answer[0]=gcd;
	        answer[1]=(n*m)/gcd;
	        return answer;
	    }
	  int GCD(int a, int b)
	 {
	     if(b==0)return a;
	     else return GCD(b,a%b);
	 }
}
