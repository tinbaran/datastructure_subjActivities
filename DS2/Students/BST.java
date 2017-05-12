import java.util.*;


public class BST{
 
 Object item;
 BST left;
 BST right;
 public static BST root;

 public BST(Object item, BST left, BST right){
  setItem(item);
  setLeft(left);
  setRight(right);
 }
 
 public BST(){
   this(null,null,null);
	
 }
 

 public BST(Object item){
  this(item,null,null);
 }
  
 public void insert(Object item){
		BST node = new BST(item);
	
		if(root==null){
			root = node;
			return;
		}
		BST current = root;
		BST parent = null;
		while(true){
			parent = current;
			if(Integer.parseInt(item.toString())<Integer.parseInt(current.item.toString())){				
				current = current.left;
				if(current==null){
					parent.left = node;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = node;
					return;
				}
			}
		}
	}
 
 public boolean delete(Object item){
		BST parent = root;
		BST current = root;
		boolean isLeftChild = false;
		while(Integer.parseInt(current.item.toString()) != Integer.parseInt(item.toString())){
			parent = current;
			if(Integer.parseInt(current.item.toString()) > Integer.parseInt(item.toString())){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}

		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}

		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			BST successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
}
	
public BST getSuccessor(BST p){
		BST successsor =null;
		BST successsorParent =null;
		BST current = p.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		
		if(successsor!=p.right){
			successsorParent.left = successsor.right;
			successsor.right = p.right;
		}
		return successsor;
}

    public boolean search(Object item)
      {
      	BST current = root;
         
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

  
 public void setItem(Object item){this.item = item;}
 public void setLeft(BST left){this.left = left;}
 public void setRight(BST right){this.right = right;}
 
 public Object getItem(){return item;}
 public BST getLeft(){
  return left;
 }
 
 
 
 public BST getRight(){
  return right;
 }
 
 public boolean isEmpty(){
  return this == null;
 }
 
public void preOrder()
{
	preOrder(root);
}

private void preOrder(BST r)
{
	if (r != null)
	{

   	System.out.print(r.getItem() +" ");
		preOrder(r.getLeft());             
		preOrder(r.getRight());
	}
}

public void inOrder()
{
	inOrder(root);
}

private void inOrder(BST r)
{
	if (r != null)
	{

		inOrder(r.getLeft());  
      System.out.print(r.getItem() +" ");           
		inOrder(r.getRight());
	}
}

public void postOrder()
{
	postOrder(root);
}

private void postOrder(BST r)
{
	if (r != null)
	{

		postOrder(r.getLeft());             
		postOrder(r.getRight());
      System.out.print(r.getItem() +" ");

	}
}

public void levelOrder()
{
	levelOrder(root);
}

private void levelOrder(BST r){
   QueueLink q = new QueueLink();
   BST p;
   
      
      q.enqueue(root);
      
      while(!q.isEmpty()){
         p = (BST)q.qFront();
         System.out.print(p.item + " "); 
         
                  
         if(p.left != null)
            q.enqueue(p.left);
         if(p.right != null)
            q.enqueue(p.right); 
      
      q.dequeue(); 
      
      }
   
 }
 
public void display(BST root){
		if(root!=null){
			display(root.getLeft());
			System.out.print(" " + root.item);
			display(root.getRight());
		}
}
 
 
 public static void main(String [] args){  
 
 Scanner scan = new Scanner(System.in);

        BST bst = new BST(); 


        char ch;

        do    

        {

            System.out.println("\n------Binary Search Tree Operations------\n");

            System.out.println("1. Insert");
            
            System.out.println("2. Search");

            System.out.println("3. Delete");

            
 
            System.out.println("Enter your choice of BST operations:\n");
            int choice = scan.nextInt();            

            switch (choice)

            {

            case 1 : 
            
                System.out.println("Enter number of elements you want to insert: \n");

                int count = scan.nextInt();
                
                System.out.println("Enter integer element to insert: \n");
                for(int i = 1; i <= count; i++){
                   bst.insert(scan.nextInt());  
                }
                System.out.print("\n");
                System.out.print("Pre-order: ");		
                bst.preOrder(bst.root);
                System.out.print("\n");
                System.out.print("Inorder: ");		
                bst.inOrder(bst.root);
                System.out.print("\n");
                System.out.print("Post-order: ");		
                bst.postOrder(bst.root);  
                System.out.print("\n");
                System.out.print("Level-order: ");		
                bst.levelOrder(bst.root);  
                System.out.print("\n");                 

                break;                          

            case 2 : 

                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search(scan.nextInt()));

                break;                         

            case 3 : 

                System.out.println("Enter integer element to delete: ");
                
                bst.delete(scan.nextInt());
                System.out.print("\n");
                System.out.print("Pre-order: ");		
                bst.preOrder(bst.root);
                System.out.print("\n");
                System.out.print("Inorder: ");		
                bst.inOrder(bst.root);
                System.out.print("\n");
                System.out.print("Post-order: ");		
                bst.postOrder(bst.root);  
                System.out.print("\n");  
                System.out.print("Level-order: ");		
                bst.levelOrder(bst.root);  
                System.out.print("\n");
                break;                                        

            default : 

                System.out.println("Wrong Entry \n ");

                break;   

            }

 

            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);                        

        } while (ch == 'Y'|| ch == 'y');               

    }
 
 
 /* BST bst = new BST();
  
		bst.insert(3);
		bst.insert(8);
		bst.insert(1);
		bst.insert(4);
		bst.insert(6);
		bst.insert(2);
		bst.insert(10);
		bst.insert(9);
		bst.insert(20);
		bst.insert(25);
		bst.insert(15);
		bst.insert(16);
		
  System.out.print("\n\t\t ------------------------------------------------- \t\t\n");
  System.out.print("\n\t\t  Original Tree : ");
  bst.display(root);		
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  Smallest: " + bst.smallest(root) + " \t\t\n");
  System.out.print("\n\t\t  Largest: " + bst.largest(root) + " \t\t\n");
  System.out.print("\n\t\t  Sum: " + bst.sum(root) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + bst.search(2) + " \t\t\n");
  System.out.print("\n\t\t  Found: " + bst.search(13) + " \t\t\n");
  System.out.print("\n\t\t  Height: " + bst.height(root) + " \t\t\n");
  System.out.print("\n\t\t  Number of nodes: " + bst.countNodes() + " \t\t\n");
  System.out.print("\n\t\t  Empty: " + bst.isEmpty() + " \t\t\n");
  System.out.print("\n\t\t  pre-order: ");
  bst.preOrder(bst.root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  inorder: ");
  bst.inOrder(bst.root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  post-order: ");
  bst.postOrder(bst.root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  Delete Node with no children : " + bst.delete(2) + " \t\t\n");
  System.out.print("\n\t\t  RESULT NODES : ");
  bst.display(root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  Delete Node with one child : " + bst.delete(4) + " \t\t\n");
  System.out.print("\n\t\t  RESULT NODES : ");		
  bst.display(root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t  Delete Node with Two children : " + bst.delete(10) + " \t\t\n");
  System.out.print("\n\t\t  RESULT NODES : ");		
  bst.display(root);
  System.out.print("\n\t\t");
  System.out.print("\n\t\t ------------------------------------------------ \t\t\n");
  
  }*/
}