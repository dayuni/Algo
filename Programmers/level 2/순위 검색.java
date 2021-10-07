import java.util.*;
class Solution {
    static HashMap<String,ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        // 경우의 수 저장
        for(String s : info){
            String[] str = s.split(" ");
            comb("",0,str);
        }
        int idx = 0;
        // 점수 list 정렬
        List<String> list = new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++){
            List<Integer> numList = map.get(list.get(i));
            Collections.sort(numList);
        }      
        for(String s : query){
            s = s.replaceAll(" and ","");
            String[] str = s.split(" ");
            int num = Integer.parseInt(str[1]);
            answer[idx++] = search(str[0],num);
        }
        return answer;
    }
    public static void comb(String s,int depth,String[] info){
        if(depth == 4){
            int num = Integer.parseInt(info[4]);
            if(map.containsKey(s))map.get(s).add(num);
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(s,list);
            }
            return;
        }    
        comb(s+"-",depth+1,info);
        comb(s+info[depth],depth+1,info);
    }
    public static int search(String query, int num){
        if(!map.containsKey(query)) return 0;
        ArrayList<Integer> list = map.get(query);
        int start = 0, end = list.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(num>list.get(mid)) start=mid+1;
            else end = mid-1;
        }
        return list.size()-start;
    }
}
