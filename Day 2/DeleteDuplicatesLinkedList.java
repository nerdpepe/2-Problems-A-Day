import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class DeleteDuplicatesLinkedList
{
    public static Node removeDuplicates(Node head) {
		//if there are ZERO or only ONE node
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		//if there are TWO or MORE
		Node top = head;
		Node prev = null;
		Node curr = head;
		
		while(curr!= null) {
			if(prev != null && curr != null) {
				if(prev.data != curr.data) {
					prev.next = curr;
					prev = curr;
				}
			}
			//initial pos
			if(prev == null)
				prev = curr;
			
			//checking at the end of the linked list for duplicates
			if(curr.next == null && prev!=curr)
				prev.next = null;
			
			//iterating to the next node
			curr = curr.next;
		}
		return top;
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }