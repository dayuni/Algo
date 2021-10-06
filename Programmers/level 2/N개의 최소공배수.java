class Solution {
    public int solution(int[] arr) {
        int n = arr[0];
        for(int i=0;i<arr.length;i++){
            n = lcm(n,arr[i]);          
        }
        return n;
    }
    static int gcd(int a, int b) {
	    while(b!=0) {
				 int r=a%b;
				 a=b;
				 b=r;
		}
		return a;
	}
     static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
}
