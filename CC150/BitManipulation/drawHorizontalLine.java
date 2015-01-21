/** 5.8 A monochrome screen is stored as a single array of bytes, allowing eight consective pixels to be
 *  stored in one byte. The screen has width w, where w is divisible by 8(that is, no byte will be split across
 *  rows). The height of the screen, of course, can be derived from the length of the array and the width. Implemnt
 *  a function drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) which draws a horizontal line
 *  from (x1, y) to (x2, y).
 */

//9:14PM

/** I think
 *  [0][1][2][3][4][5][6][7]
 *  [0][1][2][3][4][5][6][7]
 *  
 *  width = w, height = array.length/w
 *  get x1, x2: element is (y-1)*w + x
 *  screen[0] = int byte[8]
 */

public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
	int byte_length = 8;
	int start_byte_id = width/8*(y-1)+ x1/8;
	int start_bit_id = x1%8;
	int end_byte_id = width/8*(y-1) + x2/8;
	int end_bit_id = x2%8;
	
	//set x1 to its end in its byte all 1
	for(int byte_id = start_byte_id, int mask = 0; byte_id<=end_byte_id; byte_id++){
		maskt = (1<<byte_length)-1;
		if(start_byte_id == end_byte_id)// when they are in the same byte
			mask = ((1<<start_bit_id)-1) && (~(1<<end_bit_id)-1);
		else{
			if(byte_id == start_byte_id)
				mask = (1<<start_bit_id)-1;
			if(byte_id == end_byte_id)
				mask = ~((1<<end_bit_id)-1);
		}
		screen[byte_id] |= mask;//set bit need '|'
	}
}

//9:36PM

/** Book solution
 *  almost same, some logic need to be corrected for when start_byte_id == end_byte_id
 */