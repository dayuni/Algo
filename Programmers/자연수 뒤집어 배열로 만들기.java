class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String str = Long.toString(n);
        String[] tmp = str.split("");
        answer = new int[tmp.length];
        int idx =0;
        for(int i=tmp.length-1;i>=0;i--){
            answer[idx++] = Integer.parseInt(tmp[i]);
        }
        return answer;
    }
}
