/** Find the presence of a given word in a given grid, 
 *  word can be matched in any direction up-down, down-up, 
 *  left-right, right-left, both diagonals up and down etc.
 */

//21:43 

/** I think
 *  O(n^2), traverse
 *  top-down, left-right: start [0~N-len][0~N-len]
 *  then down-top, right-left: start [len-1~N-1][len-1~N-1]
 */
 
ArrayList<Integer> findWord(char[][] mat, int N, String word){
	//two direction all in one:
	searchTopDown(1);
	searchLeftRight(1);
	searchDiagonal(mat, N, word);
	return null;
}

ArrayList searchTopDown(char[][] mat, int N, String word){
	ArrayList<Integer> coord = new ArrayList<Integer>();
	for(int c=0; c<N-word.length(); c++){
		for(int r=0; r<N-word.length(); r++){
			coord.removeAll();
			int i = 0;
			while(mat[r][c] == word.charAt(i) && i<word.length()){
				coord.add(new Coordinate(r,c));
				i++;
			}
			if(coord.size() == word.length())
				return coord;
		}
	}
	for(c=N-1; c>word.length()-2; c--){
		for(r=N-1; r> word.length()-2; r--){
			coord.removeAll();
			i = 0;
			while(mat[r][c] == word.charAt(i) && i<word.length()){
				coord.add(new Coordinate(r,c));
				i++;
			}
			if(coord.size() == word.length())
				return coord;
		}
	}
	return null;
}