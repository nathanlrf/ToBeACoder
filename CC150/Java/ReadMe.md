Chap 14 Java : the language and syntax
=== 

1. Keyword:
	- final: avoid changes
		1. for variable: a primitive type variable is immutable(cannot change)
		2. for method: cannot be overriden by subclass
		3. for class: cannot subclass
	- finally: for try...catch, finally block is guaranteed to be executed
		- The finally block will be executed after the try&catch, but before control transfer back to its origin
		```java
		public static String lem(){
			println("lem");
			return "return from lem";
		}
		
		public static String foo(){
			int x=0;
			int y=1;
			try{
				print("start try");
				int b = y/x;
				print("end try");
			}catch(Exception ex){
				print("catch");
				return lem+"|return from catch";
			}finally{
				print("finally");
			}
		}
		
		//when called foo, the output is:
		//	1:	start try
		//	2: 	catch
		//	3: 	lem
		//	4:	finally		-- finally run before foo() terminates, but after the lem() print, before the lem() return 
		//	5:	return from lem|return from catch
		```
	- finalize method: automatic garbage collector calls this to destroy object.
	
2. Overloading VS. Overriding:
	- overload is for same name but different arguments(different function signature)
		- note **different return type** does **not** lead to overloading!!
	- overriding share same name and function signature as a method in **super class**.
	
3. Collection framework:
	1. ArrayList: dynamically resizing array(double its size)
	2. Vector: similar to ArrayList, except that it is synchronized.
	3. [LinkedList](http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html): seems to be double linked list
	4. HashMap
