import java.util.Scanner;
// Other imports go here
// Do NOT change the class name
class Node
{
  int data;
  Node next;
  Node(int d)
  {
    data=d;
  }
}

class Main
{
  static Node insertEnd(Node head, int data)
  {
    Node newLink = new Node(data);
    Node last = head;
    newLink.next = null;   // link new node to NULL as it is last node
    if (head == null)  // if list is empty add in beginning.
    {
      head = newLink;
      return head;
    }
    while (last.next != null)  // Find the last node
      last = last.next;
    last.next = newLink;  // Add the node after the last node of list
    return head;
  }

  static void forwardPrint(Node head)
  {
    Node current = head; // start at beginning of list
    while(current != null) // until end of list,
    {
      System.out.print(current.data + " "); // print data
      current = current.next; // move to next link
    }
  }
    // Return the head of updated list
static Node shiftSmallLarge(Node head) {
    if(head ==null || head.next ==null){
        return head;
    }
  // Write your code here
    Node maxNode =  head;
    Node prevmax = null;
    Node curr = head.next ;
    Node prev = head;
    Node lastNode = head;
    while(curr!=null){
        if(curr.data > maxNode.data){
            maxNode  = curr;
            prevmax = prev;
            
        }
        prev = curr;
        curr= curr.next;
       
        }
     lastNode = prev ;
     if(lastNode != maxNode){
         if(prevmax ==null){
             head = head.next;
         }
         else{
              prevmax.next = maxNode.next;
         }
     
      lastNode.next = maxNode;
      maxNode.next =null;
    }
    Node minNode = head;
    Node prevmin = null;
    curr = head.next;
    prev = head;
    while(curr!=null){
        if(curr.data < minNode.data){
            minNode = curr;
            prevmin = prev; 
        }
        prev = curr;
        curr= curr.next;
        
        
    }
    if(minNode != head){
            prevmin.next = minNode.next;
            minNode.next = head;
            head = minNode;
        }
    return head;
}

public static void main(String[] args)
  {
    int t,n,m;
    Scanner s = new Scanner(System.in);
    t=Integer.parseInt(s.nextLine().trim());
    while(t>0)
    {
      Node head = null;
      n=Integer.parseInt(s.nextLine().trim());
      while(n>0)
      {
        m=Integer.parseInt(s.nextLine().trim());
        head = insertEnd(head, m);
        n--;
      }
      head = shiftSmallLarge(head);
      forwardPrint(head);
      System.out.print("\n");
      t--;
    }
  }
}