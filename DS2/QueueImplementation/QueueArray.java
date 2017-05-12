public class QueueArray implements Queue {
     Object[] array;
     int count;
     int rear, front; 
    
    public QueueArray(int capacity) {
        array = new Object[capacity];
        count = 0;
        rear = front = 0;
    }
    
    public QueueArray(){
      this(10);
    }

    public void enqueue(Object item) {
         if(isEmpty())
            array[rear] = item;
         
         else if(!isFull()){
            
            rear = next(rear);
            array[rear] = item;
         }
         
         count++;
    }

    public void dequeue() {
    
        array[front]= null;
        front = next(front);
        count--;

    }

   public boolean isFull()
   {
      return count==array.length;
   }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }
    
    public Object qFront(){
      return array[front];
    }
    
    public Object qRear(){
      return array[rear];
    }
    
    public void clear(){
      for(int i = 0; i < count(); i++){
         array[i] = null;
         count = 0;	
      }
    }
    
    private int next(int pos){
  
      return (pos + 1) % array.length;
    }
    
    public String toString(){
   StringBuffer sb = new StringBuffer();
   sb.append("{");
   QueueArray q = this;
   if(!isEmpty()){
    int i = front;
   do{
     sb.append(array[i] + " ");
     i = next(i);
     }while(i != next(rear) );
  
   }
   sb.append("}");
   return sb.toString();
  }
  
  
   public static void main(String [] args){
   QueueArray qA = new QueueArray();
     qA.enqueue(4);
     qA.enqueue(8);
     qA.enqueue(5);
     qA.enqueue(9);
     qA.enqueue(7);
     qA.enqueue(2);
     qA.enqueue(6);
     qA.enqueue(2);
     
     System.out.println("Queue contains : " + qA);
     
     qA.dequeue();
     qA.dequeue();
     System.out.println("Queue contains : " + qA);
     qA.enqueue(11);
     qA.enqueue(3);
     qA.enqueue(14);
     qA.enqueue(10);
     System.out.println("Queue contains : " + qA);
     System.out.println("The qFront is: " + qA.qFront());
     System.out.println("The qRear is: " + qA.qRear());
     qA.clear();
     System.out.println("Queue contains : " + qA);

    
  }
}