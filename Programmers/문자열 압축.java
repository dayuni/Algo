class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int n=1;n<=s.length()/2;n++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i+=n){
                String pre="";
                if(i+n>=s.length()){
                    pre = s.substring(i,s.length());
                }else{
                    pre = s.substring(i,i+n);
                }                
                int cnt=1;
                StringBuilder sb2 = new StringBuilder();
                for(int j=i+n;j<s.length();j+=n){
                    String pre2="";
                    if(j+n >=s.length()){
                        pre2=s.substring(j,s.length());
                    }else{
                        pre2 = s.substring(j,j+n);
                    }
                    if(pre.equals(pre2)){
                        cnt++;
                        i=j;
                    }else break;
                }
            if(cnt==1)sb2.append(pre);
            else sb2.append(cnt).append(pre);
            
            sb.append(sb2.toString());
            }
        answer = Math.min(answer,sb.toString().length());   
        }
        
        return answer;
    }
}
