import java.util.regex.Pattern;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s=s.toLowerCase();
        String str[] = s.split(" ");
        for(int i=0;i<str.length;i++){
            if(str[i].equals("")){
                sb.append(str[i]);
            }else if(Pattern.matches("^[a-z]*$",str[i].substring(0,1))){
                sb.append(str[i].substring(0,1).toUpperCase() + str[i].substring(1));
            } else {
                sb.append(str[i]);
            }
            if(i!=str.length-1) sb.append(" ");
        }
        if(s.substring(s.length()-1).equals(" "))
            sb.append(" ");
        return sb.toString();
    }
}
