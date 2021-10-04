import java.util.*;
class Solution {
    static int count=0;
    static  HashSet<Integer> set = new HashSet<>(); 
    public int solution(String numbers) {
        String arr[] = numbers.split("");
       
        boolean visited[] = new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            dfs(arr,visited,0,arr.length,i+1,"");
        }
        return set.size();
    }
    public void dfs(String[] nums,boolean[] visited,int start, int n, int r, String tmp){
        if(start==r){
            int num = Integer.parseInt(tmp);
            if(num>1&&isPrime(num)){
               set.add(num);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
            visited[i] =true;
            dfs(nums,visited,start+1,n,r,tmp+nums[i]);
            visited[i]=false;
            }
        }
    }
     public static boolean isPrime(int num){
	        for(int i=2; i*i<=num; i++){
	            if(num % i == 0) return false;
	        }
	        return true;
	  }
}
