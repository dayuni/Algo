class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int arr[][] = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    arr[i][j]=0;
                    continue;   
                }
                arr[i][j] = 500001;
            }
        }
        for(int i=0;i<road.length;i++){
            int a = road[i][0]-1;
            int b = road[i][1]-1;
            if(arr[a][b]<road[i][2])continue;
            arr[a][b] = arr[b][a] = road[i][2];
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j)continue;
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            if(arr[0][i]<=K)
                answer++;
        }
        
        return answer;
    }
}
