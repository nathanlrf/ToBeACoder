// using ArrayList to generate a stack
  2 public class MyStack{
  3         private java.util.ArrayList list = new java.util.ArrayList();
  4 
  5         public boolean isEmpty(){
  6                 return list.isEmpty();
  7         }
  8 
  9         public int getSize(){
 10                 return list.size();
 11         }
 12 
 13         public Object peek(){
 14                 return list.get(getSize()-1);
 15         }
 16 
 17         public Object pop(){
 18                 Object o= list.get(getSize()-1);
 19                 list.remove(getSize()-1);
 20                 return o;
 21         }
 22 
 23         public void push(Object o){
 24                 list.add(o);
 25         }
 26 
 27         public int search(Object o){
 28                 return list.lastIndexOf(o);
 29         }
 30 
 31         public String toString(){
 32                 return "Stack"+list.toString();
 33         }
 34 }
