/** 1.7 Write an alg such that if an element in an M*N matrix is 0, its entire row and column are set to 0
*/

/** I think
	scan the matrix, find zeros index and record, then set rows and columns to zero
	O(M*N) for find 0s, if find n 0s, set rows and columns to 0: O(M) and O(N) for each
	can use a set to record rows that are reset.
*/
class Zeros{
	private int row;
	private int col;
	
	public Zeros(int r, int c){
		row = r;
		col = c;
	}
	
	public void setRowAndColZero(char[][] matrix, int M, int N){
		ArrayList<Zeros> zeros = new ArrayList<Zeros>();
		for(int r=0;r<M;r++){
			for(int c=0;c<N;c++){
				if(matrix[r][c] == 0){
					Zeros zero = new Zeros(r,c);
					zeros.add(zero);
				}
			}
		}
		
		for(Zeros z:zeros){
			for(int i=0;i<z.row;i++){
				matrix[z.row][i]= 0;
			}
			for(int j=0;i<z.col;++){
				matrix[j][z.col]= 0;
			}
		}
	}
}

/** BOOK SOLUTION:
	The trick here is if I find a 0 and set its row and column to 0, then after several iteration the whole matrix is all zero.
	Basically similar to mine, but she use two list to record rows and columns to be reset. So it is similar that I use two Set.
	Every time find a zero, add it to set:
	if(find zero){
		rowSet.add(row);
		colSet.add(col);
	}
	This is O(n).
	She come up with a O(1) solution! use the first row and first column to record if there is a zero in row/col:
	1 1 12 3 4
	12
	0
	3
	4
	
	first check if first row/col as zeros, use two variable to record state
	for the rest of matrix, if find mat[i][j] = 0, set mat[0][j] = mat[i][0] = 0: use the first row/col to record!
	then iterate first row/col to nullify row/col
*/
