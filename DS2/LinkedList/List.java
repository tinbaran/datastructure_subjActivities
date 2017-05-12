interface List{
 boolean isEmpty();
 boolean isFull();
 boolean isFound(int e);//search an element from the list
 void insertItem(int e);//insert an element on the desired position
 boolean remove(int e);//remove the specified element
 void clear();
}