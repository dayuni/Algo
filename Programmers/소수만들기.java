class Solution {
    static int count=0;
	 public int solution(int[] nums) {	       
	        boolean[] visited= new boolean[nums.length];
	        combination(nums,visited,0,nums.length,3,0);
	        return count;
	    }
	 // arr 조합을 뽑을 배열, visited 방문 체크, start 시작 인덱스, n 배열 길이, r 조합 길이
	 static void combination(int[] arr, boolean[] visited, int start, int n, int r,int sum) {
		 if(r==0) {
			 if(isPrime(sum))
				 count++;
			 return;
		 }
		 
		 for(int i=start;i<n;i++) {
			 visited[i] = true;
			 combination(arr,visited,i+1,n,r-1,sum+arr[i]);
			 visited[i] = false;
		 }
	 }
	 public static boolean isPrime(int num){
		 // 해당 숫자의 √N 까지 확인 
	        for(int i=2; i*i<=num; i++){
	            if(num % i == 0) return false;
	        }
	        return true;
	  }
}
