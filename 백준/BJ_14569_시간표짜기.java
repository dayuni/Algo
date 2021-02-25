package study_9월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14569_시간표짜기 {
	static int N,t[],M,q[],ans[];
	static List<int[]> tList = new ArrayList<>();
	static List<int[]> sList = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int k=Integer.parseInt(st.nextToken()); // 각 과목의 수업 시간의 수 
			t = new int[k];
			for(int j=0;j<k;j++) {
				t[j]=Integer.parseInt(st.nextToken());
			}
			tList.add(t);
		}
		M = Integer.parseInt(in.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int p=Integer.parseInt(st.nextToken()); // 각 과목의 수업 시간의 수 
			q = new int[p];
			for(int j=0;j<p;j++) {
				q[j]=Integer.parseInt(st.nextToken());
			}
			sList.add(q);
		}
		ans = new int[M];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				int cnt =0;
				int sSize = sList.get(i).length;
				int tSize = tList.get(j).length;
				for(int k=0;k<sSize;k++) {
					for(int l=0;l<tSize;l++) {
						if(sList.get(i)[k]==tList.get(j)[l]) {
							cnt++;
						}
					}
				}
				if(cnt==tSize) {
					ans[i]++;
				}
			}
		}
		for(int i=0;i<M;i++) {
			System.out.println(ans[i]);
		}
	}
}
