package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 
public class BJ_3085 {
    static int N, result = Integer.MIN_VALUE;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++) {
            String str = in.readLine();
            for(int j=0; j<N; j++)
                arr[i][j] = str.charAt(j);
        }
        
        for(int i=0; i<N; i++) {					// 양옆으로 바꿔줌
            for(int j=0; j<N-1; j++) {
                char tmp = arr[i][j];				// 현재 위치의 사탕과 다음 위치의 사탕 바꿔줌 
                arr[i][j] = arr[i][j+1];			
                arr[i][j+1] = tmp;
                result = Math.max(result, checkCandy());	// 이 때 가장 많은 사탕 찾기 
                
                tmp = arr[i][j];					// 바꿔줬던 사탕 위치 제자리로
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = tmp;
            }
        }
        for(int j=0; j<N; j++) {
            for(int i=0; i<N-1; i++) {				// 위아래로  바꿔줌
                char tmp = arr[i][j];
                arr[i][j] = arr[i+1][j];
                arr[i+1][j] = tmp;
                result = Math.max(result, checkCandy());
                tmp = arr[i][j];
                arr[i][j] = arr[i+1][j];
                arr[i+1][j] = tmp;
            }
        }
        System.out.println(result);
    }
    private static int checkCandy() {
        int max = 1;								
        for(int i=0; i<N; i++) {
            int cnt = 1;							// 무조건 1개는 있음 1부터 시작
            for(int j=1; j<N; j++) {				
                if(arr[i][j-1] == arr[i][j]) {		// 옆으로 같은사탕들이 있을 떄
                    cnt++;							// cnt ++
                }else {
                    max = Math.max(max, cnt);		// 아닐때 최대값 체크
                    cnt = 1;						// cnt 초기화
                }
            }
            max = Math.max(max, cnt);				// 최종 최대값 체크
        }
        for(int j=0; j<N; j++) {
            int cnt = 1;
            for(int i=1; i<N; i++) {
                if(arr[i-1][j] == arr[i][j]) {
                    cnt++;
                }else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}
 
