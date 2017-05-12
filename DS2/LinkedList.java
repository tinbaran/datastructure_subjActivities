public class LinkedList implements List{
  Node head;
  int count;//count the number of elements in the linked list
  
  public LinkedList(){
   head = null;
   count = 0;
  }
  
  public boolean isEmpty(){
   return count == 0;
  }
  
  public boolean isFull(){
   return false;
  }
  
  public void addFirst(int item){
   Node newNode  = new Node(item,head);
   head = newNode;
   count++;
  }
  
  public int count(){
  	return count;
	}
	
  public void addLast(int item){
   Node p = head;
   while(p.getLink() != null){
    p = p.getLink();
   }
   Node newNode = new Node(item);
   p.setLink(newNode);
   count++;
  }
  
  public boolean isFound(int e){
  	Node p = head;   

        
        while ( p != null ) {
               
            if ( e == p.getItem() )
					  
					return true;
					p = p.getLink();
               
        }

        return false;
  
  }
  
  public void insertItem(int e){
 	     
         if (isEmpty() || head.getItem() > e)
         {
            addFirst(e);
          
         }
      
         else {
            
               Node current = head;
              
            while (current.getLink() != null && current.getLink().getItem() < e){
                   current = current.getLink();
                  
            } 
            Node new_node = new Node(e);
            new_node.setLink(current.getLink());
            current.setLink( new_node);	
            count++;
         }
  }
  
public boolean remove(int e){
  
      
            Node current = head;
            Node prev = head;
          
     while(current != null) {
                     if(isEmpty()){
                        return false;
                     }
                     else if (current.getItem() == e && prev == current){
                           head = current.getLink();
                           if(head == null){
                              head.setLink(null);
                              count--;
                              return true;
                           }
                        }
                        
                     else if(current.getItem() == e){ 
                               prev.setLink(current.getLink());
                               return true;
                              
                        }
            
              prev = current;
              current = current.getLink();
              
           }
           prev.setLink(null);
           
           
          return false;  
          
                
}
  
  public int getOddSum(){
  
      Node p = head;
      Node next = head.getLink();
      int sumOdd = 0;
      
      while(p.getLink() !=null){
         count++;
         p = p.getLink();
         if((count % 2) != 0){
            
            sumOdd = sumOdd + p.getItem();
         }
         
      }
      return sumOdd;
  }
  
  public void clear()
	{
		
      head = null;
      count=0;
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
  
  public static void main(String [] args){
   LinkedList list = new LinkedList();
  
		  list.insertItem(2);
		  list.insertItem(1);
		  list.insertItem(5);
		//  list.insertItem(4);
		//  list.insertItem(3);
        list.insertItem(14);
      //  list.insertItem(10);
        
   System.out.println("List contains: " + list);
   System.out.println("There are " + list.count() + " elements." );
	System.out.println("Element found: " + list.isFound(1));
	System.out.println("Element deleted: " + list.remove(5));
   System.out.println("The sum of odd numbers: ");
   list.getOddSum();
  	System.out.println("List contains after deleting an item: " + list);    
   System.out.println("There are " + list.count() + " elements." );
	list.clear();
	System.out.println("list cleared! -- " + list);
	
  }
}