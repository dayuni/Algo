package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17471 {
	static int N,p[],arr[][],K,combs[],sum,min,tmp;
	static boolean v[],visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		p = new int[N+1];
		arr = new int[N+1][N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1;i<=N;i++) {
			p[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<num;j++) {
				int check = Integer.parseInt(st.nextToken());
				arr[i][check]=1; // 연결된 곳
			}
		}
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<=(N/2);i++) {
			K = i;							// 조합 예를 들면 2개 뽑는거, 4개뽑는거 경우의 수 같으니까 N/2까지만 
			visit = new boolean[N+1];		
			comb(1,0);						// 한개 뽑는 것 부터 시작
		}
		
		if(min == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	private static void comb(int start, int cnt) {
		if(cnt==K) {						// K개 뽑았으면 끝
			sum = Integer.MAX_VALUE;
			combs = new int[N+1];			// 조합으로 뽑은 구역 체크 배열
			for(int i=1;i<=N;i++) {
				if(visit[i])combs[i]=1;		// 뽑히면 구역 A
				else combs[i]=0;			// 아니면 구역 B로 나눔
			}
			check(); 						// 지역구 잘 나눠졌는지 확인
			min = Math.min(min, sum);		// 최소값 
			return;
		}
		for(int i=start;i<=N;i++) {			// 조합 재귀
			visit[i]=true;
			comb(i+1,cnt+1);
			visit[i]=false;
		}
	}
	private static void check() {
		v=new boolean[N+1];
		int p1=0;						// 지역구 A 합
		int p2=0;						// 지역구 B 합
		for(int i=1;i<=N;i++) {			// A지역구의 구역들이 연결되어있는지 
			if(combs[i]==1&&!v[i]) {	
				tmp =0;
				gary(i);
				p1 = tmp;
				break;
			}
		}
		for(int i=1;i<=N;i++) {			// B지역구의 구역들이 연결되어 있는지
			if(combs[i]==0&&!v[i]) {
				tmp =0;
				gary(i);
				p2 = tmp;
				break;
			}
		}
		for(int i=1;i<=N;i++) {			// 방문하지 않은 곳이 존재하면 끝
			if(!v[i])return;
		}
		sum = Math.abs(p1-p2);
	}
	private static void gary(int a) {
		v[a]=true;
		tmp = tmp+p[a];					// 연결된 지역의 인구수를 더함
		for(int i=1;i<=N;i++) {
			// 현재 지역구 방문했는지, i와 a가 같은 지역구에 속해있는지, 연결되어있는지 검사
			if(!v[i]&&(visit[i]==visit[a])&&arr[i][a]==1) {
				gary(i);
			}
		}
		
	}
}
