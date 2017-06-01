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

}
