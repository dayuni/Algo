import java.util.*;
class Solution {
    static boolean visited[];
    static List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0,tickets,"ICN","ICN");
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;        
    }
    public static void dfs(int depth,String[][] tickets, String now,String ans){
        if(depth==tickets.length){
            list.add(ans);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(!visited[i]&&tickets[i][0].equals(now)){
                visited[i]=true;
                dfs(depth+1,tickets,tickets[i][1],ans+" "+tickets[i][1]);
                visited[i]=false;
            }
        }
    }
}
