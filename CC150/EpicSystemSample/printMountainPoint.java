/** Given a M * N matrix, if the element in the matrix is larger than other 8 elements who stay around it, 
 *  then named that element be mountain point. Print all the mountain points.
 */

/** I think
 *  1 2 3
 *  4 * 6
 *  7 8 9
 *  row_start = 0, col_start = 0,offset = 3
 *  [row_start, row_start + offset][col_start, col_start+offset]
 *  row_start = 0~M-2, col_start = 0~N-2
 *  getMaxAround();
 */

void printMountainPoint(int[][] matrix, int M, int N){
	int row_start = 1;
	int col_start = 1;
	
	for(int row = row_start;row <M-1; row++){
		for(int col = col_start;col <N-1; col++){
			if(isMP(row,col,matrix)){
				System.out.print("row: "+i+"; col: "+j);
				//there is a faster way: if a mountain point is found, matrix[row][col+1] must not be MP
				col++;
			}
		}
	}
	
}

boolean isMP(int row, int col, int[][] matrix{
	int offset = 3;
	int candidate = matrix[row][col];
	int max = Integer.min;
	for(int i = row-1;i<=row+1;i++){
		for(int j=col-1;j<col+1;j++){
			if(max<matrix[i][j])
				max = matrix[i][j];
		}
	}
	return max == candidate;
}