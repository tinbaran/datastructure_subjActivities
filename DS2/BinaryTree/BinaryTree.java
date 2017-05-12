public class BinaryTree{
 
  Object item;
  BinaryTree left;
  BinaryTree right;
  
  public BinaryTree(Object item, BinaryTree left, BinaryTree right){
   this.item = item;
   this.left = left;
   this.right = right;
  }
  
  public BinaryTree(Object item){
   this(item,null,null);
  }
  
  public BinaryTree(){
   this(null, null, null);
  }
  
  //setters
  
  public void setLeft(Object item){
   this.left = new BinaryTree(item);
  }
  
  public void setRight(Object item){
   this.right = new BinaryTree(item);
  }
  
  //getters
  public BinaryTree getLeft(){return left;}
  
  public BinaryTree getRight(){return right;}
  
  public void build(){
   this.setLeft(60);
   this.setRight(70);
   this.getLeft().setRight(40);
   this.getLeft().setLeft(30);
   this.getRight().setLeft(80);
  }
  
  //inorder
  
  public boolean isEmpty(){
   return this == null;
   }
  public void inOrder(){
  if(!isEmpty()){
   if(left != null)
    left.inOrder();
   System.out.print(this.item + " ");
   if(right != null)
    right.inOrder();
   }
  }
  
  public void preOrder(){
  System.out.print(this.item + " ");
  if(!isEmpty()){
   if(left != null)
    left.preOrder();
   if(right != null)
    right.preOrder();
   }
  }
  
  public void postOrder(){
  if(!isEmpty()){
   if(left != null)
    left.postOrder();
   if(right != null)
    right.postOrder();
   System.out.print(this.item + " ");

   }
  }
  
  
 public void levelOrder(){
   QueueLink q = new QueueLink();
   BinaryTree p;
   
      
      q.enqueue(this);
      
      while(!q.isEmpty()){
         p = (BinaryTree)q.qFront();
         System.out.print(p.item + " "); 
         
                  
         if(p.left != null)
            q.enqueue(p.left);
         if(p.right != null)
            q.enqueue(p.right); 
      
      q.dequeue(); 
      
      }
   
 }
  
 public int smallest(){
   int smallest = 0;
   int smallestLeft = 0;
   int smallestRight = 0;
   
      if(!isEmpty())
         smallest = Integer.parseInt(this.item.toString());
         if(left != null){
               smallestLeft = left.smallest();
            if(smallestLeft < smallest)
               smallest = smallestLeft;
         
            else
               smallest = smallest;
         }
         if(right != null){
            smallestRight = right.smallest();
            if(smallestRight < smallest)
               smallest = smallestRight;
            else
               smallest = smallest;
          
         }
   return smallest;
 }
 
  public int largest(){
   int largest = 0;
   int largestRight = 0;
   int largestLeft = 0;
   
   if(!isEmpty())
      largest = Integer.parseInt(this.item.toString());
      if(right != null){
         largestRight = right.largest();
         if(largestRight > largest)
            largest = largestRight;
         else
            largest = largest;
      }
      if(left != null){
         largestLeft = left.largest();
         if(largestLeft > largest)
            largest = largestLeft;
         else
            largest = largest;
      }
   return largest;
 }
 
 public int sum(){
   int sum = 0;
   int leftSum = 0;
   int rightSum = 0;
   
   if(!isEmpty())
      sum = Integer.parseInt(this.item.toString());
   if(left != null)
      leftSum = left.sum();
   if(right != null)
      rightSum = right.sum();
   
   return sum + leftSum + rightSum;
 
 }
 
     public int addEven(){
      int sum = 0;
      int leftEven = 0;
      int rightEven = 0;
      
      if(!isEmpty()){
         if(Integer.parseInt(this.item.toString())%2 == 0)
         sum = Integer.parseInt(this.item.toString());
      if(left != null){
         if(Integer.parseInt(left.item.toString())%2 == 0)
         leftEven = left.addEven();
         }
      if(right != null){
         if(Integer.parseInt(right.item.toString())%2 == 0)
         rightEven = right.addEven();
         }
      }
      return sum + leftEven + rightEven;      
    }
    
    public int addOdd(){
      int sum = 0;
      int leftOdd = 0;
      int rightOdd = 0;
      
      if(!isEmpty()){
         if(Integer.parseInt(this.item.toString())%2 != 0)
         sum = Integer.parseInt(this.item.toString());
      if(left != null){
         if(Integer.parseInt(left.item.toString())%2 != 0)
         leftOdd = left.addEven();
         }
      if(right != null){
         if(Integer.parseInt(right.item.toString())%2 != 0)
         rightOdd = right.addEven();
         }
      }
      return sum + leftOdd + rightOdd;      
    }
    
    public int countNodes()

     {

         return countNodes(this);

     }


     private int countNodes(BinaryTree p){
         
         if (p == null)

             return 0;

         else

         {
             int l = 1;

             l += countNodes(p.getLeft());

             l += countNodes(p.getRight());
				 return l;

         }

     }
     
     public boolean search(Object item)
      {
      	BinaryTree current = this;
         
      		while(current != null){
      			if(Integer.parseInt(current.item.toString())== Integer.parseInt(item.toString())){
      				return true;
      			}else if(Integer.parseInt(current.item.toString())> Integer.parseInt(item.toString())){
      				current = current.left;
      			}else{
      				current = current.right;
      			}
      		}
      	return false;
      }

     
    public int height(){
       if(this.isEmpty()){
           return 0;
       }
       else{
           BinaryTree node = this;
           return height(node);
       }
   }
   private int height(BinaryTree aNode){
       int heightLeft = 0;
       int heightRight = 0;
       if(aNode.left!=null)
           heightLeft = height(aNode.left);
       if(aNode.right!=null)
           heightRight = height(aNode.right);
       if(heightLeft > heightRight){
           return heightLeft+1;
       }
       else{
           return heightRight+1;
       }
   }

  public static void main(String [] args){
   BinaryTree tree = new BinaryTree(51);
   tree.build();
   
  System.out.print("\n\t\t ------------------------------------------------- \t\t\n");		
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  Smallest: " + tree.smallest() + " \t\t\n");
  System.out.print("\n\t\t  Largest: " + tree.largest() + " \t\t\n");
  System.out.print("\n\t\t  Sum: " + tree.sum() + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(2) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(13) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(5) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(25) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(30) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + tree.search(70) + " \t\t\n");
  System.out.print("\n\t\t  Height: " + tree.height() + " \t\t\n");
  System.out.print("\n\t\t  Number of nodes: " + tree.countNodes() + " \t\t\n");
  System.out.print("\n\t\t  Empty: " + tree.isEmpty() + " \t\t\n");
  System.out.print("\n\t\t  pre-order: ");
  tree.preOrder();
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  inorder: ");
  tree.inOrder();
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  post-order: ");
  tree.postOrder();
  System.out.print("\n\t\t");
  System.out.print("\n\t\t ------------------------------------------------ \t\t\n");
  }
  
}