
public class QueueLink implements Queue{
  Object items;
  Node head, tail;
  int count;
  
  
  public QueueLink(Object size){
   items = size;
   count = 0;
   head = tail = null;
  }
  
  public QueueLink(){
   this(10);
  }
  
  	public boolean isEmpty()
	{
		return head == null || tail == null && count == 0;
	}
   
  public boolean isFull(){
   return false;
  }
	
  public void enqueue(Object item){


   Node newNode = new Node(item);
   
   if(tail == null){
     head = tail = newNode;
	  }
   else{
	 	tail.setLink(newNode);
   	tail = newNode;
		count++;
   }
   
  }
  
  public void dequeue(){
  Node temp = null;
  
  if(!isEmpty()){
   temp = head;
   head = temp.getLink();
   temp.setLink(null);
	count--;
   }
  }
  
  public Object qFront(){
    return head.getItem();
  }
  
  public Object qRear(){
    return tail.getItem();
  }
  
  public void clear(){
		head = tail = null;	
      count = 0;
  }
  
  public int size(){
   return count;
  }
  
   
  public String toString(){
   StringBuffer sb = new StringBuffer();
   sb.append("{");
   Node temp = head;
   while(temp != null){
    sb.append(temp.getItem() + " ");
    temp = temp.getLink();
   }
   sb.append("}");
   return sb.toString();
  }
  
 public static void main(String [ ]args){
  QueueLink qL = new QueueLink();
  qL.enqueue(4);
  qL.enqueue(8);
  qL.enqueue(5);
  qL.enqueue(9);
  qL.enqueue(7);
  qL.enqueue(2);
  qL.enqueue(6);
  qL.enqueue(2);
  
  System.out.println("Queue contains : " + qL);
  
  qL.dequeue();
  qL.dequeue();
  System.out.println("Queue contains : " + qL);
  qL.enqueue(11);
  qL.enqueue(3);
  qL.enqueue(14);
  qL.enqueue(10);
  System.out.println("Queue contains : " + qL);
  System.out.println("The qFront is: " + qL.qFront());
  System.out.println("The qRear is: " + qL.qRear());
  System.out.println("Size: " + qL.size());
  qL.clear();
  System.out.println("Queue contains : " + qL);
  
 }
}