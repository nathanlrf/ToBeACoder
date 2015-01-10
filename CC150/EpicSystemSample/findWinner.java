/** N*N matrix is given with input red or black. You can move horizontally, vertically or diagonally. 
 *  If 3 consecutive same color found, that color will get 1 point. 
 *  So if 4 red are vertically then point is 2. 
 *  Find the winner.
 *  http://www.careercup.com/question?id=5669721374457856
 */
 
//start 21:20
 
/** I think: 
 *  search horizontally/vertically/diagonally: solved before; given a start coord, search from left to right, up to down
 *  get score: get the longest same color segment with length L, socre = L-2;
 *  got all the score for horizontally/vertically/diagonally, then add up
 *  brute force: traverse the matrix
 */
 
// suppose red=0, black = 1;
int findWinner(int[][] matrix, int N){
	int red = 0;
	int black = 0;
	int red_score = 0;
	int black_score = 0;
	for(int r=0;r<N;r++){//horizontally
		for(int c=0;c<N;c++){
			if(matrix[r][c] == 0){
				red++;
				if(black > 3)
					black_score += black - 2;
				black = 0;
			}
			else{
				if(red > 3)
					red_score += red - 2;
				red = 0;
			}
		}
	}
	
}
// 21:41