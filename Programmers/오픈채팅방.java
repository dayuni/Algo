import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
 public String[] solution(String[] record) {
		String[] answer = {};
		List<String[]> list = new LinkedList<>();
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (str[0].equals("Enter")) {               
                map.put(str[1],str[2]);
				list.add(str);
			}else if(str[0].equals("Leave")) {
				list.add(str);
			}else {
				map.put(str[1], str[2]);
			}
		}
		answer = new String[list.size()];
        int idx =0;
		for(String[] str : list){
            String nickName = map.get(str[1]);
            if(str[0].equals("Enter")){
                answer[idx++]=nickName +"님이 들어왔습니다.";
            }else{
                answer[idx++]=nickName+"님이 나갔습니다.";
            }
        }
		return answer;
	}
}
