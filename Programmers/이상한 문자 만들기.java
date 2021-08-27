class Solution {
   public static String solution(String s) {
		 String answer = "";
		 String[] temp = s.split(" ",-1);
		     for (int i = 0; i < temp.length; i++) {
		         for (int j = 0; j < temp[i].length(); j++) {
		             if (j % 2 == 0) {
		                 if (temp[i].charAt(j) >= 'a' && temp[i].charAt(j) <= 'z') {
		                     answer += (char) (temp[i].charAt(j) - 32);
		                 } else answer += temp[i].charAt(j);
		             } else {
		                 if (temp[i].charAt(j) >= 'A' && temp[i].charAt(j) <= 'Z') {
		                     answer += (char) (temp[i].charAt(j) + 32);
		                 } else
		                     answer += temp[i].charAt(j);
		             }
		         }
		         if(!(i==temp.length-1))
		         answer+= " ";
		     }
		     return answer;
		 }
}
