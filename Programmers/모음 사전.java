import java.util.*;
class Solution {
  static String s[] = {"A","E","I","O","U"}; 
	static List<String> result = new LinkedList<>();
  public int solution(String word) {		 
	     int answer = 0;
	     for(int i=1;i<=s.length;i++) {
	    	 perm(0,i,"");
	     }
	     Collections.sort(result);
	     answer = result.indexOf(word)+1;
	     return answer;
	    }
	 static void perm(int cnt, int limit, String tmp) {
		 if(cnt==limit) {
			 result.add(tmp);
			 return;
		 }
		 for(int i=0;i<s.length;i++) {
			 perm(cnt+1,limit,tmp+s[i]);
		 }
	 }
}
