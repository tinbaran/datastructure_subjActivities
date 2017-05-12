public class Node{
   private Node link;
   private int item;
   
   
   public Node(int item,Node link){ 
		setLink(link); 
		setItem(item);
	}
   public Node(int item){ 
		this(item,null); //if item is added link is pointing to null
	}
   public Node(){
		this(0,null);//empty node
	}
   
   //setters
   public void setLink(Node link){
    if(link != null)
      this.link = link;
   }
   
   public void setItem(int item){
		this.item = item;
	}
   
   //getters
   
   public Node getLink(){
		return link;
	}
   public int getItem(){
		return item;
	}
   
   public String toString(){
		return item+ "";
	}

}