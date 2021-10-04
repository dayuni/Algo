import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> count = new HashMap<>();
        HashMap<String,HashMap<Integer,Integer>> music = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
          if (!count.containsKey(genres[i])) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(i, plays[i]);
            music.put(genres[i], map);
            count.put(genres[i], plays[i]);
          } else {
            music.get(genres[i]).put(i, plays[i]);
            count.put(genres[i], count.get(genres[i]) + plays[i]);
          }
        }
        
        List<String> keySet = new ArrayList(count.keySet());
	    	Collections.sort(keySet, (s1, s2) -> count.get(s2) - (count.get(s1)));
        List<Integer> ans = new ArrayList<>();
        for(String key : keySet){
            HashMap<Integer,Integer> map = music.get(key);
            List<Integer> genre = new ArrayList(map.keySet());
            Collections.sort(genre, (s1,s2)->map.get(s2)-map.get(s1));
            ans.add(genre.get(0));
            if(genre.size()>1) ans.add(genre.get(1));
        }
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
