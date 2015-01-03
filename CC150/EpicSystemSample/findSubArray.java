/** Find the largest sum contiguous sub array. 
 *  The length of the returned sub array must be at least of length 2.
 */

// start time: 22:59
 
/** I think:
 *  sub array is part of the array from [i] to [j] inclusively, j-i>=1
 *  try to avoid negative
 *  if positive ones are adjacent, link them up, else, 
 *  primitive way:
 *  start from 0~arr.length-length, length with 1~arr.length
 */
 
/** Solution:
 *  There is a Kadane's alg for this problem:
 *  Initialize: max_so_far = 0
 *  max_ending_here = 0
 *  
 *  Loop for each element of the array
 *  (a) max_ending_here = max_ending_here + a[i]
 *  (b) if(max_ending_here < 0) max_ending_here = 0
 *  (c) if(max_so_far < max_ending_here) max_so_far = max_ending_here
 *  return max_so_far
 */
char[] findMaxSumSubArray(int[] arr){
	int lenght = 2;
	int start = 0;
	int end = arr.length - 1;
	for()
}