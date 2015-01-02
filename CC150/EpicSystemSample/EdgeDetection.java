/** Edge Detection:
 *  Two-dimensional array representation of an image can also be represented
 *   by a one-dimensional array of W*H size, where W represent row and H represent 
 *  column size and each cell represent pixel value of that image. you are also 
 *  given a threshold X. For edge detection, you have to compute difference of a pixel 
 *  value with each of it's adjacent pixel and find maximum of all differences. 
 *  And finally compare if that maximum difference is greater than threshold X. 
 *  if so, then that pixel is a edge pixel and have to display it.
 */

/** I think
 *  original: 	row: 0~W-1
 *  			col: 0~H-1
 *  now: 		0~W*H-1
 *  for [i][j]=> [i*W + j]
 *  	compute difference between [i-/+1][j-/+1]
 */