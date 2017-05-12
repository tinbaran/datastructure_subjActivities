interface Stack{
 
  //void clear();
  boolean isEmpty();
  boolean isFull();
  void push(int item);
  boolean pop();
  int stackTop();
}