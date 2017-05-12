public class MyStack implements Stack{//last-in first out
  public Node head = null;
  public int count = 0;
  public boolean isEmpty(){
   return head == null;
  }
  
  public boolean isFull()
  {
   return false;
  }
  
  public void push(int item){
   Node newNode = new Node(item, head);
   head = newNode;
   count++;
  }
  
  public boolean pop(){
    boolean flag = false;
   if(!isEmpty())
   {
    Node temp = head;
    head = head.getLink();
    temp.setLink(null);
    count--;
    flag = true;
   }
   return flag;
  }
   
   public int stackTop(){
    return head.getItem();
   }
   
   public String toString(){
    StringBuffer sb = new StringBuffer();
   // MyStack s = new MyStack();
   Node p = head;
    sb.append("{");
    while(p != null){
     sb.append(p.getItem()+ " " );
     //s.pop();
     p = p.getLink();
    }
    sb.append("}");
    return sb.toString();
   }
   //main
   public static void main(String [ ]args){
    MyStack stack = new MyStack();
    stack.push(4);
    stack.push(5);
    stack.push(7);
    System.out.println("stack contains: " + stack);
    stack.pop();
   System.out.println("stack contains: " + stack);
   stack.pop();
   System.out.println("stack contains: " + stack);


   }
  }

