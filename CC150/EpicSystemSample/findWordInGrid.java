/** Write a program for a word search. If there is an NxN grid with one letter in each cell. 
 *  Let the user enter a word and the letters of the word are said to be found in the grid 
 *  either the letters match vertically, horizontally or diagonally in the grid. 
 *  If the word is found, print the coordinates of the letters as output.
 */
 
class Coordinate{
	private int row;
	private int col;
}

ArrayList<Integer> findWord(char[][] grid, int N, String word){
	ArrayList<Integer> index = new ArrayList<Integer>();
	for(int r = 0; r < N-1; r++){
		for(int c = 0; c<N-1; c++){
			if(word.charAt(0) == grid[r][c]){
				index = searchWord(grid, r, c, N, word);
				if(index != null)
					break;
			}
		}
	}
	return index;
}

Coordinate searchWord(char[][] grid, int r, int c, int N, String word){
	//search vertically
	if(r + word.length()-1 < N-1){
		ArrayList<Coordinate> index = new ArrayList<Coordinate>();
		for(int i=0, i<word.length();i++, r++){
			if(word.charAt(i) != grid[r][c])
				break;
			index.add(new Coordinate(r,c));
		}
		if(index.size() == word.length())
			return index;
	}
	//search horizontally
	if(c + word.length()-1 < N-1){
		ArrayList<Coordinate> index = new ArrayList<Coordinate>();
		for(int i=0, i<word.length();i++, c++){
			if(word.charAt(i) != grid[r][c])
				break;
			index.add(new Coordinate(r,c));
		}
		if(index.size() == word.length())
			return index;
	}
	//search diagonally
	if(r + word.length()-1 < N-1 && c + word.length()-1 < N-1){
		ArrayList<Coordinate> index = new ArrayList<Coordinate>();
		for(int i=0, i<word.length();i++, c++, r++){
			if(word.charAt(i) != grid[r][c])
				break;
			index.add(new Coordinate(r,c));
		}
		if(index.size() == word.length())
			return index;
	}
	return null;
}