/** The cows and bulls game, Player A chooses a word and player B guesses a word. You say bulls 
 *  when a character in the player B's guess match with a character in player A's word and also 
 *  it is in the corect position as in A's word. You say cows, when a character in the player B's 
 *  word match the character in player A, but it is not in the correct position. The characters 
 *  are case insensitive. Given two words player A's and player B's,Write a function that return 
 *  the number of bulls and no of cows. For example, 
 *  A - Picture B- Epic, bulls -0, cows - 4 
 *  A - forum B - four, bulls - 3 cows - 1
 */

/** I think
 *  
 */
 
void BullsAndCows(String a, String b){
	
}

int findBulls(String a, String b){
	int bulls = 0;
	int i=0;
	int j=0;
	while(i<a.length() && j<b.length()){
		if(a.charAt(i) == b.charAt(j))
			bulls++;
		i++;
		j++;
	}
	return bulls;
}

int findCows(String a, String b){
	int cows = 0;
	HashSet<char> seta = new HashSet<char>();
	HashSet<char> setb = new HashSet<char>();
	
	for(int i= 0;i<a.length();i++)
		seta.add(a.charAt(i));
	for(int j= 0;j<b.length();j++)
		setb.add(b.charAt(j));
	if(seta.size()>setb.size())
		seta.retainAll(setb);
	else
		setb.retainAll(seta);
	return setb.size() - findBulls(a,b);
}