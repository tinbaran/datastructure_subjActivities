

public class PostfixCalculator{
 
 public static boolean isOperand(String str){
  int number;
  try{
   number = Integer.parseInt(str);
   return true;
  }
  catch(Exception e){
   return false;
  }
 }
 
 public static boolean isOperator(String str){
  boolean flag = false;
  String operator[] = {"+","-","*","/","%"};
  for(int i = 0; i < operator.length; i++)
   if(str.equals(operator[i]))
    {
     flag = true;
     break;
    } 
    
    return flag;
 }
 
 public int calculate(String postfixExpression){
 
     MyStack opStack = new MyStack();
     MyStack valueStack = new MyStack();
     int result = 0;
     
          
    /* int r = 0;
     
        
        for(int i=0;i<postfixExpression.length();i++)
        {
            char ch=postfixExpression.charAt(i);
            if(isOperand(String.valueOf(ch)))
                stack.push((ch));
            else if(isOperator(String.valueOf(ch)))
            {
                int x=Integer.parseInt(String.valueOf(stack.pop()));
                int y=Integer.parseInt(String.valueOf(stack.pop()));
                switch(ch)
                {
                    case '+':r=x+y;
                            break;
                    case '-':r=y-x;
                            break;
                    case '*':r=x*y;
                            break;
                    case '/':r=y/x;
                            break;
                    default:r=0;
                }
                stack.push(r);
            }
        }
        r=Integer.parseInt(String.valueOf(stack.pop()));
        return(r);*/
        
        int operand1, operand2;
    //for each character ch in the string postfix
    for (int i=0; i<postfixExpression.length(); i++) {
      char ch=postfixExpression.charAt(i);
        
        if(isOperator(String.valueOf(ch))){
        switch (ch) {
        //if ch is an operator
        case '+': case '-': case '*': case '/':
          while ( (!opStack.isEmpty()) 
            && (!opStack.stackTop() == '(')
            && (precedence(ch) <= precedence((Character)opStack.stackTop()))){
           postfixExp = postfixExp + opStack.pop();
          }
          opStack.push(ch);
          break;
        case '(': //add to stack
          opStack.push(ch);
          break;
        case ')': //start popping things off the stack until you find opening parenthesis, use peak
        while (!((Character)opStack.stackTop()).equals('(')){
          postfixExp = postfixExp + opStack.pop();

          }//end while
          opStack.pop();
          break;
        default: //ch is an operand
          postfixExp = postfixExp + ch;
          break;
      }//end of switch
      }
 //   }//end of for
          
      else if(ch == isOperand(String.valueOf(ch))){
      switch (ch) {
        //if ch is an operator
        case '+':
          operand2 = Integer.parseInt(String.valueOf(valueStack.pop()));
          operand1 = Integer.parseInt(String.valueOf(valueStack.pop()));
          result = operand1 + operand2;
          valueStack.push(result);
          break;
        case '-':
          operand2 = Integer.parseInt(String.valueOf(valueStack.pop()));
          operand1 = Integer.parseInt(String.valueOf(valueStack.pop()));
          result = operand1 - operand2;
          valueStack.push(result);
          break;
        case '*':
          operand2 = Integer.parseInt(String.valueOf(valueStack.pop()));
          operand1 = Integer.parseInt(String.valueOf(valueStack.pop()));
          result = operand1 * operand2;
          valueStack.push(result);
          break;
        case '/':
          operand2 = Integer.parseInt(String.valueOf(valueStack.pop()));
          operand1 = Integer.parseInt(String.valueOf(valueStack.pop()));
          result = operand1 / operand2;
          valueStack.push(result);
          break;
        default: //ch is an operand
          valueStack.push(ch);
          break;
      }//end of switch
      }
    }//end of for
    //at the end, the value of the expression will be on the top of the stack
    result=Integer.parseInt(String.valueOf(valueStack.pop()));
    return result;
  
} 


 public static void main(String [] args){
  PostfixCalculator pf = new PostfixCalculator();
  String input;
  System.out.print("Enter postfix expression:");
  input = new java.util.Scanner(System.in).nextLine();
  String [] expression = input.split(" ");
  for(int i = 0; i < expression.length; i++){
   System.out.println(expression[i] + "\t isOperator" + isOperator(expression[i]) + "\tisOperand" + isOperand(expression[i]));
   }

 }
}