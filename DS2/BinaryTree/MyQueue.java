public class MyQueue{

  Object [] items;
  int count;
  int front, rear;
 
  
  public MyQueue(int size){
   items = new Object[size];
   count = 0;
   rear = front = 0;
  }
  
  public MyQueue(){
   this(10);
  }
  
 /* public void doubleTheArray(){
   Object temp []  = new Object[items.length * 2];
   
   int list [] = new int[items.length * 2];
		for(int i = 0; i < count; i++)
		list[i] = items[i];
		items = list;
   
  } */
  
  public boolean isEmpty()
  {
   return count == 0;
  }
  
  public boolean isFull()
  {
   return count==items.length;
  }
  public void enqueue(Object item){
   //check if queue is empty()
   if(isEmpty())
   items[rear] = item;
   //else if not empty
   else if(!isFull()){
      //doubleTheArray();
   rear = next(rear);
   items[rear] = item;
   }
  
   
   count++;
  }
  
  public void dequeue()
  {
   items[front]= null;
   front = next(front);
   count--;
  }
  
  public void clear(){
		front = rear = null;	
  }
  
  public Object qFront(){
    return front.getItem();
  }
  
  private int next(int pos){
  
   return (pos + 1) % items.length;
  }
  
  public String toString(){
   StringBuffer sb = new StringBuffer();
   MyQueue q = this;
   if(!isEmpty()){
    int i = front;
   do{
     sb.append(items[i] + " ");
     i = next(i);
     }while(i != next(rear) );
  
       }
   return sb.toString();
  }
  
  
   public static void main(String [] args){
   MyQueue queue = new MyQueue();
   queue.enqueue(1);
   queue.enqueue(2);
   queue.enqueue(3);
   queue.enqueue(4);
   queue.enqueue(5);
   queue.dequeue();
   queue.enqueue(6);
   queue.enqueue(7);
   queue.enqueue(8); 
   queue.enqueue(9);
   queue.enqueue(10);
   queue.enqueue(11);
   System.out.println("queue has: " + queue);
    
  }
}