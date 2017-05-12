interface Queue{
  boolean isEmpty();
  void clear();
  boolean isFull();
  Object qFront();
  Object qRear();
 void enqueue(Object item);
  void dequeue();
}

/*
 Create the QueueArray and QueueLink that implements the interface Queue
*/