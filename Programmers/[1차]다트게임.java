class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int num[] = new int[3];
        char dart[] = dartResult.toCharArray();
        int cnt = -1;
        
        for(int i=0;i<dart.length;i++){
            // S인 경우 점수 계산
            if(dart[i]>='0'&&dart[i]<='9'){
                cnt++;
                if(dart[i]=='1'&&dart[i+1]=='0'){
                    // 10인 경우
                    num[cnt]=10;
                    i++;
                }else{
                    num[cnt] = dart[i]-'0';
                }
            // D인 경우 제곱 
            }else if(dart[i]=='D'){
                num[cnt] *= num[cnt];
            // T인 경우 세제곱 
            }else if(dart[i]=='T'){
                num[cnt]*= num[cnt]*num[cnt];
            }else if(dart[i]=='*'){
                // *인경우 인덱스가 0보다 크면 이전값도 *2
                if(cnt>0){
                    num[cnt-1]*=2;
                }
                num[cnt]*=2;
                // #이면 * -1
            }else if(dart[i]=='#'){
                num[cnt]*=-1;
            }
            
        }
       answer = num[0]+num[1]+num[2];
        return answer;
    }
}
