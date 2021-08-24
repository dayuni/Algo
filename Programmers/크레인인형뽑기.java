import java.util.*;
class Solution {
 public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<moves.length;i++) {	        	
	        	for(int j=0;j<board.length;j++) {
	        		if(board[j][moves[i]-1]!=0) {
	        			if(stack.isEmpty()) {
	        				// 스택이 비어있을 때 스택에 인형을 넣어준다
	        				stack.push(board[j][moves[i]-1]);
	        				// 인형을 뽑아간 자리는 0으로 바꿔줌
	        				board[j][moves[i]-1]=0;
	        				break;
	        			}
	        			else {
	        				if(board[j][moves[i]-1]==stack.peek()) {
	        					// 스택의 top과 뽑은 인형이 같을 떄
	        					stack.pop();
	        					// 터트린다
	        					board[j][moves[i]-1]=0;
	        					// 사라진 인형의 개수를 카운트
	        					answer+=2;
	        					break;
	        				}else {
	        					// 서로 다른 인형인 경우 스택에 넣어준다
	        					stack.push(board[j][moves[i]-1]);
	        					board[j][moves[i]-1]=0;
	        					break;
	        				}
	        			}
	        			
	        		}
	        	}
	        }
	        return answer;
	    }
}
