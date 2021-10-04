import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        for(int i=0;i<str1.length()-1;i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            if(Character.isLetter(a)&&Character.isLetter(b)){
                String str = Character.toString(a)+Character.toString(b);
                list1.add(str);
            }
        }
        
         for(int i=0;i<str2.length()-1;i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            if(Character.isLetter(a)&&Character.isLetter(b)){
                String str = Character.toString(a)+Character.toString(b);
                list2.add(str);
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        for(String s : list1){
            if(list2.contains(s)){
                list2.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s:list2){
            union.add(s);
        }
        
        double a = intersection.size();
        double b = union.size();
        
        double similarity = 0;
        if(union.size()==0) similarity =1;
        else similarity = (double) intersection.size()/(double) union.size();
            
        int answer = (int) (similarity*65536);
        return answer;
    }
}
