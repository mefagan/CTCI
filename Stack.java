package crackingCodingInterview;

import java.util.EmptyStackException;

public class Stack<T> {
  private static class StackNode<T> {
    private T value;
    private StackNode<T> next;
    
    public StackNode(T data) {
      value = data;
    }
  }
  private StackNode<T> top;
  
  public T pop() {
    if (top==null) {
      throw new EmptyStackException();
    }
    T item = top.value;
    top = top.next;
    return item;
  }
  
  public void push(T item) {
    StackNode<T> newItem = new StackNode<T>(item);
    newItem.next = top;
    top = newItem;
  }
  
  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.value;
  }
  
  public boolean isEmpty() {
    return top==null;
  }

}
