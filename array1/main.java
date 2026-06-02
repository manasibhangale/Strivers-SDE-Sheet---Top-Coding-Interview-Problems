class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean firstRowZero=false;
        boolean firstColZero=false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                firstColZero=true;
                break;
            }
        }

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0){
                firstRowZero=true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(firstColZero){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
/*
Set Matrix Zeroes (Optimal) — Steps Only
Check first row for any zero and store in firstRowZero.
Check first column for any zero and store in firstColZero.
Traverse the matrix (excluding first row and first column):
If matrix[i][j] == 0
Set matrix[i][0] = 0
Set matrix[0][j] = 0
Traverse again (excluding first row and first column):
If matrix[i][0] == 0 || matrix[0][j] == 0
Set matrix[i][j] = 0
If firstRowZero == true,
Make the entire first row 0.
If firstColZero == true,
Make the entire first column 0.
Memory Trick

Check → Mark → Fill → First Row → First Column.
0 1 2 0
3 4 5 2
1 3 1 5

0 0 0 0
0 4 5 0
0 3 1 0*/