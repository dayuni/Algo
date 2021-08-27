class Solution {
    public int solution(int n) {
        int answer = 0;
           for(int i=2; i<=n; i++){
	         if(isPrime(i)) answer++;  
	        }
        return answer;
    }
    public static boolean isPrime(int num){
		 // 해당 숫자의 √N 까지 확인 
	        for(int i=2; i*i<=num; i++){
	            if(num % i == 0) return false;
	        }
	        return true;
	  }
    
}
