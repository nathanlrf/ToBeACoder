/** Jumper Game: A NxN grid which contains either of 0-empty, 1 - player1, 2 - player 2. 
 *  Given a position in the grid, find the longest jump path. For jump path, you can 
 *  horizontally or vertically, you can jump on opponent cell and also the landing cell 
 *  should be empty. No opponent cell can be jumped more than once. Write a function which 
 *  takes grid and a specific position in the grid, and returns the longest possible number 
 *  of jumps in the grid.
 */

/** I think
 *  x x x x x 
 *  x x x x x
 *  x x x x x
 *  x x x x x
 *  x x x x x
 *  given [i][j], check [i-1][j], [i+1][j], [i][j-1], [i][j+1]
 */
class Index{
	int[][] grid;
	int row;
	int col;
	boolean used = false;
	
	public Index(int r, int c){
		row = r;
		col = c;
	}
	
	int getCell(){
		return grid[row][col];
	}
	
	Index up(){
		if(row-1<0)
			return null;
		return new Index(row-1,col);
	}
	Index down(){
		if(row+1==N)
			return null;
		return new Index(row+1,col);
	}
	Index left(){
		if(col-1<0)
			return null;
		return new Index(row, col-1);
	}
	Index right(){
		if(col+1 == N)
			return null;
		return new Index(row, col+1);
	}
}
int findNextStep(Index input){	
	int player = input.getCell();
	int opponent = 2- player/2;
	int step;
	if (player == 0)
		return null;
	//dfs
	Index up = input.up();
	Index down = input.down();
	Index left = input.left();
	Index right = input.right();
	
	if(up == opponent && up.up() == 0 && !up.used())
		up.used = true;
		step = findNextStep(up) + 1;
	else if(down == opponent && down.down() == 0 && !down.used())
		down.used = true;
		step = findNextStep(down) + 1;
	else if(left == opponent && left.left() == 0 && !left.used())
		left.used = true;
		step = findNextStep(left) + 1;
	else if(right == opponent && up.up() == 0 && !right.used())
		right.used = true;
		step = findNextStep(right) + 1;
	else
		return 0;
	return step;

}
