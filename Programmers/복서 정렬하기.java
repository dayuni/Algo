import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public class Boxer implements Comparable<Boxer> {
		int no;
		int weight;
		int winCount;
		double winRate;

		public Boxer(int no, int weight, int winCount, double winRate) {
			this.no = no;
			this.weight = weight;
			this.winCount = winCount;
			this.winRate = winRate;
		}

		@Override
		public int compareTo(Boxer o) {
			if (this.winRate > o.winRate) {
        // 승률 높은지 확인
				return -1;
			} else if ((this.winRate == o.winRate) && (this.winCount > o.winCount)) {
				// 승률 같다면 자신보다 무거운 복서를 이긴 횟수 확인
        return -1;
			} else if ((this.winRate == o.winRate) && (this.winCount == o.winCount) && (this.weight > o.weight)) {
				// 승률, 이긴 횟수 같으면 자신의 무게가 더 높은지 확인
        return -1;
			} else if ((this.winRate == o.winRate) && (this.winCount == o.winCount) && (this.weight == o.weight)
					&& (this.no < o.no)) {
        // 자신의 무게까지 같다면 복서의 번호가 작은지 확인
				return -1;
			} else
				return 1;
		}
	}

	public int[] solution(int[] weights, String[] head2head) {
		int[] answer = new int[weights.length];
		ArrayList<Boxer> list = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			int totalWin = 0;
      int totalLoose =0;
			int heavyWin = 0;
			for (int j = 0; j < head2head[i].length(); j++) {
				if (head2head[i].charAt(j) == 'W') {
					if (weights[i] < weights[j]) {
            // 나보다 무거운 복서를 이겼을 경우
						  heavyWin++;
					}
					   totalWin++;
				} else if(head2head[i].charAt(j)=='L'){
            totalLoose++;
         }
			}
      double rate =0;
      if(totalWin==0&&totalLoose==0) rate = 0; // 싸운 전적이 없는 경우 승률은 0
			else rate = (double)totalWin / (totalWin+totalLoose);
			Boxer boxer = new Boxer(i + 1, weights[i], heavyWin, rate);
			list.add(boxer);
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i).no;
		}

		return answer;
	}

}
