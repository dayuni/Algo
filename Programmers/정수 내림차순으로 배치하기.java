import java.util.Arrays;
class Solution {
 public static long solution(long n) {
	        long answer = 0;
	        String str = Long.toString(n);
	        String s[] = str.split("");
	        Arrays.sort(s);
	        String tmp = "";
	        for(int i=s.length-1;i>=0;i--) {
	        	tmp += s[i];
	        }
	        answer = Long.parseLong(tmp);
	        return answer;
	    }
}
