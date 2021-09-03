import java.util.*;
class Solution {
   	public Map<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        map = new HashMap<>();                                    // 문자열과 주문 횟수를 저장할 map
        List<String> list = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            String str[] = orders[i].split("");                   // 문자열을 split
            Arrays.sort(str);                                     // 정렬해준다 
            for(int j=0;j<course.length;j++){
                boolean visited[] =new boolean[str.length];
                comb(str,visited,0,str.length,course[j],"");      // 주문한 메뉴중에서 코스메뉴개수만큼 뽑는 조합
            }
        }
         int max[] = new int[course.length];
        for(int i=0;i<course.length;i++) {
        	  for(String s : map.keySet()){
                  if(map.get(s)>=2&&s.length()==course[i]) {      // 주문횟수가 2번 이상이면서 코스메뉴 개수와 같을 때 최대 주문 횟수 확인
                	  max[i] = Math.max(max[i], map.get(s));
                  }
              }
        }
        
        for(int i=0;i<course.length;i++) {                         // 최대 주문 횟수일때 리스트에 추가
      	  for(String s : map.keySet()){
                if(s.length()==course[i]&&map.get(s)==max[i]) {
                	list.add(s);
                }
            }
      }
        answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
        answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    public void comb(String[] orders,boolean[] visited, int start, int n, int r,String course){
        if(r==0){
             if(!map.containsKey(course)){                   // 현재 이 코스가 map에 없으면 추가 해주고 횟수 1
                map.put(course,1);
            }else{
                map.put(course,map.get(course)+1);            // 이 코스가 있을 때 횟수만 + 1
            }
            return;
        }
        for(int i=start;i<n;i++){
            visited[i]=true;
            String tmp = course + orders[i];
            comb(orders,visited,i+1,n,r-1,tmp);
            visited[i]=false;
        }
    }
}
