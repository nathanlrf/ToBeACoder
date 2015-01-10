/** Substring Addition
 *  Write a program to add the substring
 *  eg :say you have a list {1 7 6 3 5 8 9 } and user is entering a sum 16.
 *  Output should display (2-4) that is {7 6 3} cause 7+6+3=16.
 */

/** I think:
 *  suppose all positive
 *  should maintain a list of sum for substring length 1~N
 *  Binary search:
 *  To find 16, get length 4 = 17, length 3 = 14,
 *  In length 3 find substring whose sum = 17 - 16=1
 *  if sum_list[N-1] < diff, return;
 *  if sum_list[i] = diff, return i~upper_b
 *  if sum_list[0] > diff, return
 */
 
void SubstringAddition(int[] list, int N, int sum){
	int sum_list = new int[N];
	int upper_b = -1;
	for(int i=0; i<N;i++){
		if(i == 0)
			sum_list[i] = list[i];
		else{
			sum_list[i] = sum_list[i-1] + list[i];
		}
		if(sum_list[i] >= sum && upper_b == -1)//find the smallest element that is bigger than sum
			upper_b = i;
	}
	int diff = sum_list[i] - sum;
	if(diff > sum_list[N-1] || diff < sum_list[0])
		return;
	for(int j=0; j<i;j++){
		if(sum_list[i] == diff){
			String str= "";
			str = "( "+(i+1)+" - "+j+" )";
			System.out.println(str);
		}
	}
}