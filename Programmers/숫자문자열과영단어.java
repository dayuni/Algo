class Solution {
    public int solution(String s) {
        int answer = 0;
	        String num[]= {"0","1","2","3","4","5","6","7","8","9"};
	        String english[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	        for (int i = 0 ; i <10 ; i++){
	            s = s.replace(english[i] , num[i]); // 영어로 된 값을 해당되는 숫자로 치환
	        }
	        return Integer.parseInt(s);
    }
}
