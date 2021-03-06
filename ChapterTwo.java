package crackingCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class ChapterTwo {

  public static ListNode removeDuplicates(ListNode head) {
    ListNode start = head;
    Map<Integer, Boolean> valueMap = new HashMap<Integer, Boolean>();
    if (head==null || head.next==null) {
      return head;
    }
    while(head.next != null) {
      if (valueMap.get(head.next.value)!=null) {
        deleteNode(head);
      } else {
        valueMap.put(head.next.value, true);
        head = head.next;
      }
    }
    return start;
  }
  
  public static ListNode removeDuplicatesSansBuffer(ListNode head) {
    ListNode start = head;
    ListNode current = head;
    if (head==null || head.next==null) { 
      return null;
    }
    ListNode previous = null;
    while(current.next != null) {
      ListNode runner = current.next;
      while (runner != null){
        if (runner.value == current.value && previous!=null) {
          deleteNode(previous);
        }
        else if (runner.value == current.value) {
          start = start.next;
        }
        runner = runner.next;
      }
      previous = current;
      current = current.next;
    }
    return start;
  }
  
  public static boolean deleteNode(ListNode previousNode) {
    previousNode.next = previousNode.next.next;
    return true;
  }
  
  public static void printList(ListNode head) {
    while (head!=null) {
      System.out.println(head.value);
      head = head.next;
    }
  }
  
  public static void main(String[] args) {
    
    ListNode node1 = new ListNode(5);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(9);
    ListNode node6 = new ListNode(2);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    printList(node1);
    ListNode newlist = removeDuplicatesSansBuffer(node1);
    printList(newlist);
    
  }
  
}
