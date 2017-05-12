class Node{
 private int item;
 private Node link;
 
 //constructors
 public Node(int item, Node link){
  setItem(item);
  setLink(link);
 }
 
 public Node(int item){
  this(item, null);
 }
 
 public Node(){
  this(0,null);
 }
 
 //setters
 public void setItem(int item){
 this.item = item;
 }
 
 public void setLink(Node link){
  this.link = link;
 }
 
 public int getItem(){return item;}
 public Node getLink(){return link;}
}