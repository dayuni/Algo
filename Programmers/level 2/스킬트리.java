import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        HashSet<String> element = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String str[] = skill.split("");
        for(int i=0;i<str.length;i++){
            element.add(str[i]);
            sb.append(str[i]);
            set.add(sb.toString());
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<skill_trees.length;i++){
            String s[] = skill_trees[i].split("");
            sb = new StringBuilder();
            int count =0;
            for(int j=0;j<s.length;j++){
                if(element.contains(s[j])){
                    sb.append(s[j]);
                }else{
                    count++;
                }
            }
            if(count==s.length)answer++;
            list.add(sb.toString());
        }
        
        for(int i=0;i<list.size();i++){
            if(set.contains(list.get(i))){
                answer++;
            }
        }
        return answer;
    }
}
