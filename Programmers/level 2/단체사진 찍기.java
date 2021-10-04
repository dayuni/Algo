class Solution {
	private int answer = 0;
	private String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };

	public int solution(int n, String[] data) {
		boolean[] visited = new boolean[8];
		dfs("", visited, data);
		return answer;
	}

	private void dfs(String names, boolean[] visited, String[] datas) {
		if (names.length() == 7) {
			if (isAble(names, datas)) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				String name = names + friends[i];
				dfs(name, visited, datas);
				visited[i] = false;
			}
		}
	}

	private boolean isAble(String names, String[] datas) {
		for (int i = 0; i < datas.length; i++) {
			int idx1 = names.indexOf(datas[i].charAt(0));
			int idx2 = names.indexOf(datas[i].charAt(2));
			char op = datas[i].charAt(3);
			int gap = datas[i].charAt(4) - '0';
			if (op == '=') {
				if (!(Math.abs(idx1 - idx2) == gap + 1))
					return false;
			} else if (op == '>') {
				if (!(Math.abs(idx1 - idx2) > gap + 1))
					return false;
			} else if (op == '<') {
				if (!(Math.abs(idx1 - idx2) < gap + 1))
					return false;
			}
		}
		return true;
	}
}
