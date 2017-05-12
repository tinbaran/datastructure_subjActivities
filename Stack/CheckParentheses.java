/*
 Using Stack determine the parentheses are balance or not.
*/
import java.util.*;

public class CheckParentheses{
static Scanner console = new Scanner(System.in);
 public boolean isBalance(String str){
   MyStack s = new MyStack();
   boolean isBalance = false;
  if(str.length() % 2 == 0)
  {
   for(int i = 0; i < str.length(); i++){
    if(str.charAt(i) == '(')
     s.push(str.charAt(i));
    else if(str.charAt(i) == ')'){
      if(s.isEmpty())
       System.out.println("Stack is empty!");
      else
       s.pop();
     }
    }
     if(s.isEmpty())
      isBalance = true;
  }
  return isBalance;
 }
 public static void main(String [ ]args){
 CheckParentheses cp = new CheckParentheses();
  System.out.print("Enter parentheses: " );
  String input = console.next();
  
  System.out.println("Are parentheses balance?: " + cp.isBalance(input));
 }
 //main to test your algorithm, make this interactive
}