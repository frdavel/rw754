/*
 * Stack Requirements
  	pop(emptyStack) = emptyStack
	pop(push(x)) = x
	peek(emptyStack) = error
	peek(push(x)) = x
	empty(emptyStack) = true
	empty(push(x)) = false
 */

public class Stack {
   private int maxStack;
   private int emptyStack;
   private int top;
   private char[] items;

   public Stack(int size) {
      maxStack= size;
      emptyStack = -1;
      top = emptyStack;
      items = new char[maxStack];
   }

   public void push(char c) {
      items[++top] = c;
   }

   public char pop() {
      return items[top--];
   }

   public char peek() {
	   return items[top];
   }
   
   public boolean full()  {
      return top + 1 == maxStack;
   }

   public boolean empty()  {
      return top == emptyStack;
   }
}

