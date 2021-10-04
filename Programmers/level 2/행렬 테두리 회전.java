class Solution {
    public int arr[][];
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j] = i*columns+j+1;
            }
        }
        for(int i=0;i<queries.length;i++){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
    public int rotate(int query[]){
        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;
        
        int tmp = arr[r1][c1];
        int min = tmp;
        for(int i=r1;i<r2;i++){
            arr[i][c1] = arr[i+1][c1];
            min = Math.min(arr[i][c1],min);
        }
        
        for(int i=c1;i<c2;i++){
            arr[r2][i] = arr[r2][i+1];
            min = Math.min(arr[r2][i],min);
        }
        for(int i=r2;i>r1;i--){
            arr[i][c2] = arr[i-1][c2];
            min = Math.min(arr[i][c2],min);
        }
        for(int i=c2;i>c1;i--){
            arr[r1][i] = arr[r1][i-1];
            min = Math.min(arr[r1][i],min);
        }
        arr[r1][c1+1]=tmp;
    return min;
    }
    
}
