Epic System on Careercup
===

Problems:

1. Jumper Game: seems to be related to DP, have to work on it.

2. well ordered word: generate permutaion of characters

3. Learn to parse CSV: use Java I/O

4. Given a text and pattern, determine whether pattern appears in text:

Learned:

1. Kandane's alg(DP): find the sub continuous sequence with max sum: 
	max_end_here and max_so_far, max_end_here = max(seq[i], seq[i]+max_end_here);
	use the sub sequence sum list to find the index of the sub sequence
	
2. KMP alg: find pattern of length M in text of length N in O(N):
	basic idea: if the two part matches but the next one is unexpected: pattern[i] != text[j], shift a distance 
	that they still match: introduce prefix and suffix
	build a failure table: for length 0~M, the sub sequence that prefix = suffix