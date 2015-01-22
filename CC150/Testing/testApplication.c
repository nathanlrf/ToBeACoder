// 12.2 You are given the source to an application which crashes when it is run.
// After running it ten times in a debugger, you find it never crashes in 
// the same place. The application is single threaded, and uses only the C
// standard library. What programming errors could be causing this crash ?
// How would you test each one?

/** I think
 *  due to time ? memory ptr?
 */
 
/** Book solution
 *  1. Random variable: user input/ random number/ system time
 *  2. Uninitialized variable
 *  3. Memory leak: running out of memory. # of process/ heap overflow/ corruption of data on stack
 *  4. External dependency: depend on another application/machine/resources
 */