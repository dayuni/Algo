class Solution {
	public String solution(int[][] scores) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scores.length; i++) {			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			double avg = 0;
			int count = 0;
      int mine = scores[i][i];
			boolean flag = false;
			for (int j = 0; j < scores.length; j++) {
				// 같은 점수 있는지 확인
				if (i != j && mine == scores[j][i]) {
					flag = true;
				}
				max = Math.max(max, scores[j][i]);
				min = Math.min(min, scores[j][i]);

				// 점수를 다 더해줌
				sum += scores[j][i];
				count++;
			}

			// 내가 유일한 최고, 최저점인 경우 합에서 빼주고 카운트 감소
			if (!flag && (max == mine || min == mine)) {
				sum -= mine;
				count--;
			}
			avg = (double) sum / (double) count;
			System.out.println(avg);
			sb.append(getGrade(avg));
		}
		answer = sb.toString();
		return answer;
	}

	public static String getGrade(double score) {
		if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 50) {
			return "D";
		}

		return "F";
	}
}
