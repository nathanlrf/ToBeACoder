/** 3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in first out" basis.
 *   People must adopt either the "oldest"(based on arrival time) of all animals at the shelter, or they 
 *  can select whether they would prefer a dog or a cat(and will receive the oldest animal of that type).
 *  They cannnot select which specific animal they would like. Create the data structures to maintain this 
 *  system and implement operations such as enqueue, dequeueAny, dequeueDog and DequeueCat. You may used the 
 *  built-in LinkedList data structure.
 */
 
//10:08PM

/** I think
 *  this system should be able to:
 *  	1. get the oldest of all
 *  	2. get the oldest of cat/dog
 *  cat structure, dog structure
 *  seems like a queue
 */

class AgeQueue{
	LinkedList list;//double link
	Node head, tail;
	//tail smallest
	enqueue(item){
	}
	dequeue(){
	}
	peek(){
		return head;//get oldest age
	}
}
 
class CatsAndDogs{
	//Dog and Cat has age field
	private AgeQueue<Dog> dogs;
	private AgeQueue<Cat> cats;
	private Object oldest;
	
	//store dogs and cats in ascending order of age
	public void enqueue(Object animal){
		if(animal instanceof Dog){
			dogs.enqueue(animal);
		}else if(animal instanceof Cat){
			cats.enqueue(animal);
		}
		if(oldest == null || oldest.age < animal.age)
			oldest = animal;
	}
	
	public dequeueAny(){
		Object animal;
		if(oldest instanceof Dog)
			animal = dogs.dequeue();
		else if(oldest instanceof Cat)
			animal = cats.dequeue();
		oldest = (cats.peek()>dogs.peek())?dequeueCat():dequeueDog();
		return animal;
	}
	
	public dequeueDog(){
		Object dog = dogs.dequeue();
		oldest = (cats.peek()>dogs.peek())?dequeueCat():dequeueDog();
		return dog;
	}
	
	public dequeueCat(){
		Object cat = cats.dequeue();
		oldest = (cats.peek()>dogs.peek())?dequeueCat():dequeueDog();
		return cat;
	}
}

//10:35PM

/** Book solution
 *  almost same
 */