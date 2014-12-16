/** 1.6 Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate
	the image by 90 degrees. Can you do this in place?
*/

/** I think:
	in place require returning the updated mat, not a new one
	do it layer by layer? 
	whether N is odd or even, from a layer to next layer the increment is always 2
	start from outmost layer, rotate pixel by pixel, first length is N-1, then
	
	* * * *|*
	_
	* * *|* *
	  _
	* * * * *
		  _
	* *|* * *
			_
	*|* * * *
	0~N-1, then inner is 1~N-1, then 2~N-2, 

	* * *|*
	_
	* * * *
	* * * *
		  _
	*|* * *
	0~N-1, 1~N-3
	
*/
const int N = 10;
public char[N][N] rotateMatrixBy90(char[N][N] mat){
	for(int layer = 0; layer< N; layer++){
		int end = N - 1 - layer;
		if(layer <= end){
			for(int i=layer;i<end;i++){
				rotatePixel(layer,i,mat);
			}
		}
		else
			break;
	}
}

private void rotatePixel(int layer, int i, char[N][N] mat){
	int pixel = mat[layer][i];
	int nextx = i;
	int nexty = N-1-layer;
	for(int j=0;j<4;j++){
		nextx = i;
		nexty = N-1-layer;
		swap(layer,i,nextx,nexty);
		layer = nextx;
		i = nexty;
	}
}

/** BOOK SOLUTION:
	I reference much from the book, mainly the layer concept. I made a mistake for computing end for each layer.
	end should be: end = N-1-layer
	rotating is not done well, code in book is:
	for(i=layer;i<end;i++){
		int offset = i - layer;
		int top = mat[layer][i];
		mat[first][i] = mat[end-offset][first];
		mat[end-offset][first] = mat[end][end-offset];
		mat[end][end-offset] = mat[i][end];
		mat[i][end] = top;
	}
	
	O(n^2) no better complexity because every element has to be visited.
*/