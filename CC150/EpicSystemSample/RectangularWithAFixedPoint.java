/** Given a 2 dimensional point of a rectangle and its area, find permutations of all the other 3 points of the rectangle in 2-D space.
 *  Ex:- Given X=(0,0) and A=1
 *  (0,1),(1,0),(1,1)
 *  (0,-1),(-1,0),(-1,-1) 
 *  ...
 */
 
/** I think
 *  suppose int height and int width
 *  find the possible height and width pair by try 1~area: O(A)
 *  For a point: 
 *  	suppose normal x-y direction, only increase x and y
 *  	x+width, x+height
 *  	then do the opposite
 */