/** Given a NXN matrix, starting from the upper left corner of the matrix start printing values in a counter-clockwise fashion.
 *  Eg: Consider N = 4
 *  Matrix= {a, b, c, d,
 *  e, f, g, h,
 *  i, j, k, l,
 *  m, n, o, p}
 *  Your function should output: dcbaeimnoplhgfjk
 *  Another example would be
 *  	C I P E
 *  	R N K U
 *  	U O W O
 *  	L E S Y
 *  The function should print: EPICRULESYOUKNOW
 */
// Phone interview
 
/** start: 22:10
 *  I think: 
 *  start from [0][N-1], print 4 segments: up [0][N-1~1]; left [0~N-2][0]; down [N-1][0~N-2]; right [N-1~1][N-1]
 *  start from [1][N-2], [1][N-2~2]; [1~N-3][0]; [N-2][1~N-3]; [N-2~2][N-2]  
 *  layer = N/2;
 *  layer == 1: print the element
 *  layer >1: layer is the i
 */

void printCounterClock(char[][] mat, int N){
	int layer = 0;
	if(N == 1){
		System.out.println(mat[0][0]);
	}
	while(layer < (N-1)/2){
		printTop(mat, N, layer);
		printLeft(mat, N, layer);
		printBottom(mat, N, layer);
		printRight(mat, N, layer);
		layer++;
	}
}

void printTop(char[][] mat, int N, int layer){
	int row = layer;
	for(int col = N-1-layer; col>layer; col--){
		System.out.println(mat[row][col]);
	}
}

void printLeft(char[][] mat, int N, int layer){
	int col = layer;
	for(int row = layer; row < N-1-layer; row++){
		System.out.println(mat[row][col]);
	}
}
void printBottom(char[][] mat, int N, int layer){
	int row = N-1-layer;
	for(int col = layer; col<N-1-layer; col++){
		System.out.println(mat[row][col]);
	}
}
void printTop(char[][] mat, int N, int layer){
	int col = N-1-layer;
	for(int row = N-1-layer; row>layer; row--){
		System.out.println(mat[row][col]);
	}
}

/** end
 *  22:40
 */
