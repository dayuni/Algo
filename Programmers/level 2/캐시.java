import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return 5*cities.length;
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            if(cache.contains(city)){
                cache.remove(cache.indexOf(city));
                cache.add(city);
                answer+=1;
            }else{
                if(cache.size()<cacheSize){
                    answer+=5;
                    cache.add(city);
                }else{
                    cache.remove(0);
                    cache.add(city);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}
