class ArrayList implements List{
 int items[];
 int count;
 
 public ArrayList(int size){
  items = new int[size];
  count = 0;
 }
 
 public ArrayList(){
 	this(10);
	}
 
 public boolean isEmpty(){
 	return count == 0;
	}
 
 public boolean isFull(){
 	return count == items.length;
	}

public void insertItem(int e){
 if(isEmpty() || e < items[0])
  addFirst(e);
 else if(e > items[count -1])
  addLast(e);
 else{
  //insert item in between		
		for(int i = 0; i < count; i++){
			if(e < items[i]){
				count++;
				for(int j = count-1; j >= i; j--)
					items[j+1] = items[j];
					items[i] = e;
					break;
			}
		}
	  }
}

 public void addLast(int e){
  if(!isFull())
   items[count++] = e;
 }
 
 public void addFirst(int e){
  if(!isEmpty())
   shiftRight();
  items[0] = e;
  count++;
 }

 
 public void shiftRight()
 {
  int c = count;
  while(c > 0)
   items[c] = items[--c];
 }

public boolean remove(int e) { 
	int j; 
   if(isEmpty())
      System.out.println(" -- Array is empty!");
	for(j=0; j<count; j++){ 
 		if(e == items[j]) 
		{
		 break; 
		} 
	} 
	if(j==count)  
		return false; 
	else  
	{ 
		for(int k=j; k<count; k++)  
		items[k] = items[k+1]; 
		count--;  
		return true; 
	}
}

public boolean isFound(int e){
		boolean flag = false;
		for(int i = 0; i < count; i++)
		if(items[i] == e){
		flag = true;
		break;
		}
	return flag;
	}

public void clear()
	{
		for(int i = 0; i<count; i++) {
		items[i] = 0;
		count = 0;
    } 
	}

public String toString(){
 StringBuffer sb = new StringBuffer();
  sb.append("{");
  for(int i = 0 ; i < count; i++)
    sb.append(items[i] + " ");
   sb.append("}");
  return sb.toString();
}

	public static void main(String [] args){
	 ArrayList list = new ArrayList();
	 
	 list.insertItem(3);
	 list.insertItem(1);
	 list.insertItem(10);
	 list.insertItem(5);
	 list.insertItem(9);
    list.insertItem(15);
	 
	 System.out.println("list contains: " + list);
	 System.out.println("element found: " + list.isFound(3));
	 System.out.println("delete item: " + list.remove(15));
	 System.out.println("list contains: " + list);
	 list.insertItem(4);
	 list.clear();
	 System.out.println("list contains: " + list + " --- list cleared!");
	 
	}
}