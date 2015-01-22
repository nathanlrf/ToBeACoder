/** 12.3 We have the following method used in a chess game: boolean canMoveTo(int x, int y).
 *  This method is part of the Piece class and returns whether or not the piece can move to
 *  position(x, y). Explain how you would test this method.
 */
 
/** I think
 *  1. normal case: 
 *  	- where the piece can go all east/west/south/north directions, see if is true for this 4 directions;
 *  	test for if diagnoal is false 
 *  	- add other piece in the position original piece can/cannot go, too see whether this affect function result;
 *  2. boarder case:
 *  	piece adjacent to 1 side, repeat normal case;
 *  	piece at the corner, adjacent to 2 sides, repeat normal case
 *  3. test position out of bound:
 *  	x/y/ x&y;
 *  	test null;
 */