import java.util.*;
class Solution {
    static ArrayList<HashSet<Integer>> keySet;
    static int length,answer;
    static String table[][];
    public int solution(String[][] relation) {
        answer =0;
        keySet = new ArrayList<>();
        table = relation;
        length = relation[0].length;
        for(int i=1;i<=length;i++){
            comb(i,0,-1,new HashSet<Integer>());
        }
        return answer;
    }
    // 후보키 조합 구하기
    public static void comb(int n, int count,int idx, HashSet<Integer> set){
        if(count==n){
            if(!isUnique(set))// 유일성 검사
                return;
            for(HashSet<Integer> key : keySet){ // 이미 후보키 조합에 있는 조합이라면 추가 안함
                if(set.containsAll(key))return;
            }
            keySet.add(set); // 후보키 조합 저장
            answer++;
            return;
        }
        for(int i=idx+1;i<length;i++){
            HashSet<Integer> newSet = new HashSet<Integer>(set);
            newSet.add(i);
            comb(n,count+1,i,newSet);
        }
        
    }
    // 유일성 검사
    public static boolean isUnique(HashSet<Integer> set){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<table.length;i++){
            String str = "";
            for(int idx:set){       
                str+=table[i][idx];
            }
            if(!list.contains(str)){  // 리스트에 없는 경우에만 추가 
                list.add(str);        // 이미 리스트에 있으면 유일하지 않음
            }else return false;
        }
        return true;
    }
    
}
